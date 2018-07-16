package util.dconcurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import util.dconcurrent.core.DBytes;
import util.dconcurrent.core.DConcurrentServerGrpc;
import util.dconcurrent.core.DObject;
import util.dconcurrent.core.DStatus;
import util.dconcurrent.util.HostAndPort;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentClient {
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private final ManagedChannel channel;
    private final DConcurrentServerGrpc.DConcurrentServerFutureStub futureStub;
    public HostAndPort hostAndPort;
    public DConcurrentClient(HostAndPort hostAndPort){
        this.hostAndPort = hostAndPort;
        channel = ManagedChannelBuilder.forAddress(hostAndPort.getIp(), hostAndPort.getPort())
                .usePlaintext(true)
                .keepAliveWithoutCalls(true)
                .build();
        futureStub = DConcurrentServerGrpc.newFutureStub(channel );
    }

    public boolean isShutdown(){
        return channel.isShutdown();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ListenableFuture<DBytes> call(final byte[] className, final byte[] metaParam, final byte[] metaParamClass) {
        DObject request = builderRequest(className, metaParam, metaParamClass);
        ListenableFuture<DBytes> response = futureStub.call(request);
        return response;
    }


    public void run(final byte[] className, final byte[] metaParam, final byte[] metaParamClass){
        DObject request = builderRequest(className, metaParam, metaParamClass);
        futureStub.run(request);
    }

    public Status getStatus() throws ExecutionException, InterruptedException {
        DStatus dStatus = futureStub.getStat( DBytes.getDefaultInstance() ).get();
        Status status = new Status();
        status.setRunCount( dStatus.getRunCount() );
        status.setCallCount( dStatus.getCallCount() );
        return status;
    }

    private DObject builderRequest(byte[] className, byte[] metaParam, byte[] metaParamClass) {
        DObject.Builder builder = DObject.newBuilder();
        ByteString dRequest;
        if( className != null ){
            dRequest = ByteString.copyFrom(className);
            builder.setClassName( dRequest );
        }
        ByteString anyMetaParam;
        if( metaParam != null ){
            anyMetaParam = ByteString.copyFrom(metaParam);
            builder.setMetaParam( anyMetaParam );
        }

        ByteString anyMetaParamClass;
        if( metaParamClass != null ){
            anyMetaParamClass = ByteString.copyFrom(metaParamClass);
            builder.setMetaParamClass( anyMetaParamClass );
        }
        DObject request = builder.build();
        return request;
    }

}
