package com.lzz.dconcurrent;

import com.google.gson.Gson;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.distribute.DConcurrentServerGrpc;
import io.grpc.distribute.DObject;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentServer {
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private static Gson gson = new Gson();

    private Server server;

    public static void daemonStart(final int port){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DConcurrentServer server = new DConcurrentServer();
                try {
                    server.start(port);
                    server.blockUntilShutdown();
                }catch (Exception e){

                }
            }
        }).start();
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
        public void run(DObject request, StreamObserver<DObject> responseObserver) {
            final Any classNameObj = request.getClassName();
            final Any metaParam = request.getMetaParam();
            final Any metaParamClass = request.getMetaParamClass();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Class<?> runClass = Class.forName( classNameObj.getValue().toStringUtf8() );
                        Constructor constructorObj = runClass.getConstructor( DmetaParam.class );

                        ByteString paramClassByte = metaParamClass.getValue();
                        Object runObject;
                        if( paramClassByte.size() != 0 ){
                            Class<?> paramClass = Class.forName(paramClassByte.toStringUtf8());
                            Object metaObject = gson.fromJson(metaParam.getValue().toStringUtf8(), paramClass);
                            runObject = constructorObj.newInstance( metaObject );
                        }else{
                            runObject = runClass.newInstance();
                        }
                        Method runMethod = runClass.getDeclaredMethod( "run" );
                        runMethod.setAccessible( true );
                        runMethod.invoke( runObject ) ;
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
            DObject reply = DObject.newBuilder().setClassName( classNameObj ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }

        @Override
        public void call(DObject request, StreamObserver<DObject> responseObserver){
            final Any classNameObj = request.getClassName();
            final Any metaParam = request.getMetaParam();
            final Any metaParamClass = request.getMetaParamClass();
            Future<byte[]> future = threadPool.submit(new Callable<byte[]>() {
                @Override
                public byte[] call() throws Exception {
                    byte[] result = null;
                    try {
                        Class<?> runClass = Class.forName( classNameObj.getValue().toStringUtf8() );
                        Constructor constructorObj = runClass.getConstructor( DmetaParam.class );

                        ByteString paramClassByte = metaParamClass.getValue();
                        Object runObject;
                        if( paramClassByte.size() != 0 ){
                            Class<?> paramClass = Class.forName(paramClassByte.toStringUtf8());
                            Object metaObject = gson.fromJson(metaParam.getValue().toStringUtf8(), paramClass);
                            runObject = constructorObj.newInstance( metaObject );
                        }else{
                            runObject = runClass.newInstance();
                        }
                        Method runMethod = runClass.getSuperclass().getDeclaredMethod( "remoteCall" );
                        runMethod.setAccessible( true );
                        result = (byte[]) runMethod.invoke( runObject );
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return result;
                }
            });
            byte[] futureRes = new byte[0];
            try {
                futureRes = future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Any resultAny = Any.newBuilder().setValue( ByteString.copyFrom( futureRes ) ).build();
            DObject reply = DObject.newBuilder().setClassName( resultAny ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }
    }

}
