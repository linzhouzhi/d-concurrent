package com.lzz.dconcurrent.demo;

import io.grpc.distribute.DConcurrentServer;
import io.grpc.distribute.DExecutors;
import io.grpc.distribute.DFuture;
import io.grpc.distribute.strategy.FailStrategy;
import io.grpc.distribute.util.HostAndPort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by gl49 on 2018/7/4.
 */
public class Server1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DConcurrentServer.daemonStart(50051);
        List<HostAndPort> hostAndPortList = new ArrayList<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("192.168.31.147", 50051);
        HostAndPort hostAndPort2 = new HostAndPort("192.168.31.147", 50052);
        HostAndPort hostAndPort3 = new HostAndPort("192.168.31.147", 50053);
        hostAndPortList.add( hostAndPort1 );
        hostAndPortList.add( hostAndPort2 );
        hostAndPortList.add( hostAndPort3 );
        DExecutors client = new DExecutors( hostAndPortList, new FailStrategy() );

        while (true){
            if( !client.isLeader() ){
                System.out.println( "is not leader" );
                continue;
            }

            DmetaParamTest dmetaParam = new DmetaParamTest();
            client.submit(new TestRuannable( dmetaParam ) );

            DFuture future1 = client.submit( new TestCallable(dmetaParam) );
            dmetaParam.setAge(1110000);
            DFuture<CallResultTest> future2 = client.submit( new TestCallable(dmetaParam) );
            CallResultTest str = (CallResultTest) future1.get();
            CallResultTest str2 = future2.get();
            System.out.println("finish---------------------" + str);
            Thread.sleep(2000);
        }
    }

    public static class TestRuannable implements Runnable {
        DmetaParamTest dmetaParamTest;
        public TestRuannable(){
            //ignore
        }

        public TestRuannable(DmetaParamTest dmetaParamTest){
            System.out.println("cccc test runnbale");
            this.dmetaParamTest = (DmetaParamTest) dmetaParamTest;
        }

        @Override
        public void run() {
            System.out.println("drunnable " + this.dmetaParamTest);
        }
    }
}
