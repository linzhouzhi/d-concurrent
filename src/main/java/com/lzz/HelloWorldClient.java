package com.lzz;

/**
 * Created by lzz on 2018/3/15.
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HelloWorldClient {

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;


    public HelloWorldClient(String host,int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply   response = blockingStub.sayHello(request);
        System.out.println(response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        List l = new ArrayList();

        HelloWorldClient client = new HelloWorldClient("127.0.0.1",50052);
        for(int i=0;i<5;i++){
            client.greet("world:"+i);
        }

    }
}