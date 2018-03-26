package com.lzz.util.dconcurrent;

import com.google.gson.JsonObject;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.distribute.DConcurrentServerGrpc;
import io.grpc.distribute.DListString;
import io.grpc.distribute.DObject;
import io.grpc.distribute.DString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrent {
    List l = new ArrayList();
    private final ManagedChannel channel;
    private final DConcurrentServerGrpc.DConcurrentServerBlockingStub blockingStub;


    public DConcurrent(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = DConcurrentServerGrpc.newBlockingStub( channel );
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public FutureTask<String> submit(final Callable callable){
        FutureTask<String> futureTask = new FutureTask<String>(new Callable() {
            public String call() throws Exception {
                Class<?> className = callable.getClass();
                System.out.println( className.getName() );
                Any.Builder any = Any.newBuilder().setValue(ByteString.copyFromUtf8( className.getName() ));
                DObject request = DObject.newBuilder().setMessage( any ).build();
                DObject response = blockingStub.call(request);
                ByteString byteString = ByteString.copyFrom( response.getMessage().getValue().toByteArray() );
                //byte[] bytes = response.getMessage().getValue().toByteArray();
                //System.out.println( new String( bytes ) );
                //System.out.println( byteString.toStringUtf8() );
                return byteString.toStringUtf8();
            }
        });
        Thread thread = new Thread( futureTask );
        thread.start();
        return  futureTask;
    }

    // 可以返回自定义多 thread 然后增加 isrun 属性，来控制线程的开关闭合
    public Thread submit(final Runnable runnable){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Class<?> className = runnable.getClass();
                Any.Builder any = Any.newBuilder().setValue(ByteString.copyFromUtf8( className.getName() ));
                DObject request = DObject.newBuilder().setMessage( any ).build();
                DObject response = blockingStub.run(request);
                System.out.println(response.getMessage());
            }
        });
        thread.start();
        return thread;
    }

    private void addList(List l, String aaa) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("listName", l.getClass().getName());
        DString request = DString.newBuilder().setMessage( jsonObject.toString() ).build();
        DListString response = blockingStub.addList( request );
        System.out.println( response.getMessageList() );
    }

    public  void greet(List<String> nameList){
        DListString request = DListString.newBuilder().addAllMessage(nameList).build();
        DListString response = blockingStub.printList(request);
        System.out.println(response.getMessageList());
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List l = new ArrayList();

        DConcurrent client = new DConcurrent("127.0.0.1",50052);
        List<String> arr = new ArrayList<String>();
        for(int i=0;i<5;i++){
            arr.add( "world:"+i );
        }
        client.greet( arr );

        client.submit(new Runnable() {
            public void run() {
                System.out.println( "zzz");
            }
        });

        FutureTask futureTask = client.submit(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000);
                return "aa bb cc";
            }
        });

        System.out.println( futureTask.get() );

        client.addList(l, "aaa");

    }


}
