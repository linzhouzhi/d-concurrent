package com.lzz.dconcurrent;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.lzz.dconcurrent.util.HostAndPort;
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
    public HostAndPort hostAndPort;
    public DConcurrentClient(HostAndPort hostAndPort){
        this.hostAndPort = hostAndPort;
        channel = ManagedChannelBuilder.forAddress(hostAndPort.getIp(), hostAndPort.getPort())
                .usePlaintext(true)
                .keepAliveWithoutCalls(true)
                .build();
        blockingStub = DConcurrentServerGrpc.newBlockingStub( channel );
    }

    public boolean isShutdown(){
        return channel.isShutdown();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public Future<byte[]> call(final byte[] className, final byte[] metaParam, final byte[] metaParamClass) {
        Future<byte[]> future = threadPool.submit(new Callable<byte[]>() {
            public byte[] call() throws Exception {
                DObject request = builderRequest(className, metaParam, metaParamClass);
                DObject response = blockingStub.call(request);
                return response.getClassName().getValue().toByteArray();
            }
        });
        return  future;
    }


    public void run(final byte[] className, final byte[] metaParam, final byte[] metaParamClass){
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                DObject request = builderRequest(className, metaParam, metaParamClass);
                blockingStub.run(request);
            }
        });
    }

    private DObject builderRequest(byte[] className, byte[] metaParam, byte[] metaParamClass) {
        DObject.Builder builder = DObject.newBuilder();
        Any.Builder anyClassName;
        if( className != null ){
            anyClassName = Any.newBuilder().setValue( ByteString.copyFrom(className) );
            builder.setClassName( anyClassName );
        }
        Any.Builder anyMetaParam;
        if( metaParam != null ){
            anyMetaParam = Any.newBuilder().setValue( ByteString.copyFrom(metaParam) );
            builder.setMetaParam( anyMetaParam );
        }

        Any.Builder anyMetaParamClass;
        if( metaParamClass != null ){
            anyMetaParamClass = Any.newBuilder().setValue( ByteString.copyFrom(metaParamClass) );
            builder.setMetaParamClass( anyMetaParamClass );
        }
        DObject request = builder.build();
        return request;
    }


}
