package com.lzz.dconcurrent.util;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.distribute.DConcurrentServerGrpc;
import io.grpc.distribute.DObject;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
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
    private int port = 50052;
    private Server server;

    public static void daemonStart(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DConcurrentServer server = new DConcurrentServer();
                try {
                    server.start();
                    server.blockUntilShutdown();
                }catch (Exception e){

                }
            }
        }).start();
    }
    private void start() throws IOException {
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
            final Any classNameObj = request.getMessage();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Class<?> class1 = Class.forName( classNameObj.getValue().toStringUtf8() );
                        System.out.println( class1 + "--ccc");
                        Object object = class1.newInstance();
                        Method runMethod = class1.getDeclaredMethod( "run" );
                        runMethod.setAccessible( true );
                        runMethod.invoke( object ) ;
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
            DObject reply = DObject.newBuilder().setMessage( classNameObj ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }

        @Override
        public void call(DObject request, StreamObserver<DObject> responseObserver){
            final Any classNameObj = request.getMessage();
            Future<byte[]> future = threadPool.submit(new Callable<byte[]>() {
                @Override
                public byte[] call() throws Exception {
                    byte[] result = null;
                    Class<?> class1 = Class.forName( classNameObj.getValue().toStringUtf8() );
                    Object object = class1.newInstance();
                    Method runMethod = class1.getDeclaredMethod( "call" );
                    runMethod.setAccessible( true );
                    result = (byte[]) runMethod.invoke( object );
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
            DObject reply = DObject.newBuilder().setMessage( resultAny ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }
    }

}
