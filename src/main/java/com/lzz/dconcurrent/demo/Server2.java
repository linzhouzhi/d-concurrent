package com.lzz.dconcurrent.demo;

import util.dconcurrent.DCallable;
import util.dconcurrent.DExecutors;
import util.dconcurrent.DFuture;
import util.dconcurrent.util.HostAndPort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gl49 on 2018/7/4.
 */
public class Server2 {
    private static List list = new ArrayList();
    public static void main(String[] args) throws Exception {
        List<HostAndPort> hostAndPortList = new ArrayList<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("192.168.31.147", 50051);
        HostAndPort hostAndPort2 = new HostAndPort("192.168.31.147", 50052);
        hostAndPortList.add( hostAndPort1 );
        hostAndPortList.add( hostAndPort2 );

        DExecutors.serverStart( 50052 );
        DExecutors client = DExecutors.newRandomDExecutor(hostAndPortList);
        while (true){
            if( !client.isLeader() ){
                System.out.println( "is not leader" );
                continue;
            }

            list.add("lllllaalalla");
            list.add("goog monitor");
            client.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("good flexxxxx " + list);
                }
            });

            DFuture<List> futureList = client.submit(new DCallable() {
                @Override
                protected Object call() {
                    return list;
                }
            });
            System.out.println( "------dfuture " + futureList.get() );

            DmetaParamTest dmetaParam = new DmetaParamTest();
            client.submit(new TestRuannable( dmetaParam ) );

            DFuture future = client.submit( new TestCallableBoolean() );
            System.out.println( future.get() + "----------------------------- boolean");

            DFuture future1 = client.submit( new TestCallable(dmetaParam) );
            dmetaParam.setAge(1110000);
            DFuture<CallResultTest> future2 = client.submit( new TestCallable(dmetaParam), dmetaParam.getName());
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
