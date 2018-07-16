package util.dconcurrent;

import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.dconcurrent.core.DBytes;
import util.dconcurrent.core.DConcurrentServerGrpc;
import util.dconcurrent.core.DObject;
import util.dconcurrent.core.DStatus;
import util.dconcurrent.util.ByteTransform;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentServer {
    private Server server;
    private static int runCount = 0;
    private static int callCount = 0;

    public static void daemonStart(final int port){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DConcurrentServer server = new DConcurrentServer();
                try {
                    server.start(port);
                    server.blockUntilShutdown();
                }catch (Exception e){

                }
            }
        });
        thread.setName("dconcurrent-daemon-server");
        thread.start();
    }

    public DConcurrentServer(){

    }

    private void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new DConcurrentServer.DoncurrentImpl())
                .build()
                .start();

        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {

                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                DConcurrentServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // 实现 定义一个实现服务接口的类
    private class DoncurrentImpl extends DConcurrentServerGrpc.DConcurrentServerImplBase {
        @Override
        public void run(DObject request, StreamObserver<DBytes> responseObserver) {
            runCount++;
            final ByteString classNameObj = request.getClassName();
            final ByteString metaParam = request.getMetaParam();
            final ByteString metaParamClass = request.getMetaParamClass();
            try {
                Class<?> runClass = Class.forName( classNameObj.toStringUtf8() );
                Object runObject = getRunObject(classNameObj, metaParam, metaParamClass);
                Method runMethod = runClass.getDeclaredMethod( "run" );
                runMethod.setAccessible( true );
                runMethod.invoke( runObject ) ;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void call(DObject request, StreamObserver<DBytes> responseObserver){
            callCount++;
            final ByteString classNameObj = request.getClassName();
            final ByteString metaParam = request.getMetaParam();
            final ByteString metaParamClass = request.getMetaParamClass();
            byte[] result = null;
            try {
                Class<?> runClass = Class.forName( classNameObj.toStringUtf8() );
                Object runObject = getRunObject(classNameObj, metaParam, metaParamClass);
                Method runMethod = runClass.getSuperclass().getDeclaredMethod( "remoteCall" );
                runMethod.setAccessible( true );
                result = (byte[]) runMethod.invoke( runObject );
            }catch (Exception e){
                e.printStackTrace();
            }

            ByteString resultAny = ByteString.copyFrom(result);
            DBytes reply = DBytes.newBuilder().setRes(resultAny).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }

        @Override
        public void getStat(DBytes request, StreamObserver<DStatus> responseObserver) {
            DStatus reply = DStatus.newBuilder().setRunCount( runCount ).setCallCount( callCount ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }
    }

    private Object getRunObject(ByteString classNameObj, ByteString metaParam, ByteString metaParamClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> runClass = Class.forName( classNameObj.toStringUtf8() );
        Object runObject;
        ByteString paramClassByte = metaParamClass;
        if( paramClassByte.size() != 0 ){
            Class<?> paramClass = Class.forName(paramClassByte.toStringUtf8());
            Constructor constructorObj = runClass.getConstructor( paramClass ); //DmetaParam.class
            constructorObj.setAccessible(true);
            Object metaObject = ByteTransform.unSerialized(metaParam.toStringUtf8(), paramClass);
            runObject = constructorObj.newInstance( metaObject );
        }else{
            //测试用例会默认传递一个参数进来
            Constructor[] constructors = runClass.getDeclaredConstructors();
            Constructor constructor = constructors[0];
            constructor.setAccessible(true);
            Parameter[] params = constructor.getParameters();
            if( null != params ){
                String[] paramStrArr = new String[params.length];
                runObject = constructor.newInstance(paramStrArr);
            }else{
                runObject = constructor.newInstance();
            }
        }
        return runObject;
    }

}
