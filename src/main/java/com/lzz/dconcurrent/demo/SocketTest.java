package com.lzz.dconcurrent.demo;

import io.grpc.distribute.DConcurrentClient;
import io.grpc.distribute.Status;
import io.grpc.distribute.util.HostAndPort;
import io.grpc.distribute.util.NetUtil;
import java.io.IOException;

/**
 * Created by gl49 on 2018/7/5.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String localIp = NetUtil.getLocalIp();
        System.out.println( localIp );
        HostAndPort hostAndPort2 = new HostAndPort("10.16.164.33", 50051);
        DConcurrentClient dConcurrentClient = new DConcurrentClient( hostAndPort2 );
        Status status = dConcurrentClient.getStatus();
        System.out.println( status );
        dConcurrentClient.shutdown();
        //boolean res = NetUtil.checkIpAndPort(hostAndPort2);
        //System.out.println( res );
        HostAndPort hostAndPort = new HostAndPort("10.16.164.33", 50052);
        //boolean res2 = NetUtil.checkIpAndPort(hostAndPort2);
        //System.out.println( res2 );
        //ManagedChannel channel = ManagedChannelBuilder.forAddress(hostAndPort.getIp(), hostAndPort.getPort()).usePlaintext(true).build();
        //DConcurrentServerGrpc.newStub(channel).withDeadline(Deadline.after(1, TimeUnit.SECONDS));
    }
}
