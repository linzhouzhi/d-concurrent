package com.lzz.util.dconcurrent;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.distribute.DConcurrentServerGrpc;
import io.grpc.distribute.DListString;
import io.grpc.distribute.DObject;
import io.grpc.distribute.DString;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentServer {
    private int port = 50052;
    private Server server;

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


    public static void main(String[] args) throws IOException, InterruptedException {

        final DConcurrentServer server = new DConcurrentServer();
        server.start();
        server.blockUntilShutdown();
    }


    // 实现 定义一个实现服务接口的类
    private class DoncurrentImpl extends DConcurrentServerGrpc.DConcurrentServerImplBase {
        public void printList(DListString request, StreamObserver<DListString> responseObserver) {
            List<String> name = request.getMessageList();
            System.out.println( name );
            DListString reply = DListString.newBuilder().addAllMessage( name ).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        public void run(DObject request, StreamObserver<DObject> responseObserver){
            final Any classNameObj = request.getMessage();
            try {
                Class<?> class1 = Class.forName( classNameObj.getValue().toStringUtf8() );
                Object object = class1.newInstance();
                Method runMethod = class1.getDeclaredMethod( "run" );
                runMethod.setAccessible( true );
                runMethod.invoke( object ) ;
            }catch (Exception e){
                e.printStackTrace();
            }
            DObject reply = DObject.newBuilder().setMessage( classNameObj ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }

        public void call(DObject request, StreamObserver<DObject> responseObserver){
            Any classNameObj = request.getMessage();
            String result = null;
            try {
                Class<?> class1 = Class.forName( classNameObj.getValue().toStringUtf8() );
                Object object = class1.newInstance();
                Method runMethod = class1.getDeclaredMethod( "call" );
                runMethod.setAccessible( true );
                result = (String) runMethod.invoke( object );
            }catch (Exception e){
                e.printStackTrace();
            }
            Any resultAny = Any.newBuilder().setValue( ByteString.copyFromUtf8(result)).build();
            DObject reply = DObject.newBuilder().setMessage( resultAny ).build();
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }

        public void addList(DString request, StreamObserver<DListString> responseObserver){
            String requestStr = request.getMessage();
            Gson gson = new Gson();
            JsonObject requestJson = gson.fromJson(requestStr, JsonObject.class);
            String listName = requestJson.get("listName").getAsString();
            System.out.println( listName );
            List l = new ArrayList();
            l.add( listName );
            DListString reply = DListString.newBuilder().addAllMessage( l ).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
