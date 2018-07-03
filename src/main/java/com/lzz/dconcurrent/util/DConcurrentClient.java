package com.lzz.dconcurrent.util;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.distribute.DConcurrentServerGrpc;
import io.grpc.distribute.DObject;

import java.util.concurrent.*;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentClient {
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private final ManagedChannel channel;
    private final DConcurrentServerGrpc.DConcurrentServerBlockingStub blockingStub;

    public DConcurrentClient(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();

        blockingStub = DConcurrentServerGrpc.newBlockingStub( channel );
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public Future<byte[]> submit(final Callable callable){
        Future<byte[]> future = threadPool.submit(new Callable<byte[]>() {
            public byte[] call() throws Exception {
                Class<?> className = callable.getClass();
                Any.Builder any = Any.newBuilder().setValue(ByteString.copyFromUtf8( className.getName() ));
                DObject request = DObject.newBuilder().setMessage( any ).build();
                DObject response = blockingStub.call(request);
                System.out.println("call able");
                return response.getMessage().getValue().toByteArray();
            }
        });
        return  future;
    }

    // 可以返回自定义多 thread 然后增加 isrun 属性，来控制线程的开关闭合
    public void submit(final Runnable runnable){
        Class<?> className = runnable.getClass();
        Any.Builder any = Any.newBuilder().setValue(ByteString.copyFromUtf8( className.getName() ));
        DObject request = DObject.newBuilder().setMessage( any ).build();
        DObject response = blockingStub.run(request);
        System.out.println(response.getMessage());
    }

}
