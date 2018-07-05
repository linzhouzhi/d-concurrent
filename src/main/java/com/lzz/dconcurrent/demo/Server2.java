package com.lzz.dconcurrent.demo;

import io.grpc.distribute.*;
import io.grpc.distribute.util.HostAndPort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by gl49 on 2018/7/4.
 */
public class Server2 {
    public static List<String> res = new ArrayList<String>();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DConcurrentServer.daemonStart(50052);

        List<HostAndPort> hostAndPortList = new ArrayList<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("10.16.164.33", 50051);
        HostAndPort hostAndPort2 = new HostAndPort("10.16.164.33", 50052);
        HostAndPort hostAndPort3 = new HostAndPort("10.16.164.33", 50053);
        hostAndPortList.add( hostAndPort1 );
        hostAndPortList.add( hostAndPort2 );
        hostAndPortList.add( hostAndPort3 );
        DExecutors client = new DExecutors( hostAndPortList );

        while (true){
            if( !client.isLeader() ){
                System.out.println("is not leader");
                continue;
            }
            List<String> arr = new ArrayList<String>();
            for(int i=0;i<5;i++){
                arr.add( "world:"+i );
            }
            DmetaParamTest dmetaParam = new DmetaParamTest();
            client.submit(new TestRuannable( dmetaParam ) );

            Future future1 = client.submit( new TestCallable(dmetaParam) );
            dmetaParam.setAge(1110000);
            Future future2 = client.submit( new TestCallable(dmetaParam) );
            DFuture<CallResultTest> dFuture = new DFuture(CallResultTest.class);
            CallResultTest str = dFuture.get( future1 );
            CallResultTest str2 = dFuture.get( future2 );
            Thread.sleep(3000);
        }
    }

    public static class TestRuannable extends DRuannable {
        DmetaParamTest dmetaParamTest;
        public TestRuannable(){
            //ignore
        }

        public TestRuannable(DmetaParam dmetaParamTest){
            System.out.println("cccc test runnbale");
            this.dmetaParamTest = (DmetaParamTest) dmetaParamTest;
        }

        @Override
        protected void run() {
            System.out.println("drunnable " + this.dmetaParamTest);
        }
    }
}
