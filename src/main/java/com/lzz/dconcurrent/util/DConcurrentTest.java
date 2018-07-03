package com.lzz.dconcurrent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentTest {
    public static List<String> res = new ArrayList<String>();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DConcurrentServer.daemonStart();

        DExecutors client = new DExecutors();
        List<String> arr = new ArrayList<String>();
        for(int i=0;i<5;i++){
            arr.add( "world:"+i );
        }
        Integer count = 1000;
        /*
        client.submit(new Runnable() {
            public void run() {
                System.out.println( "zzz");
            }
        });
        */
        client.submit(new RunnableTest(count) );

        Future futureTask = client.submit(new Callable<byte[]>() {
            public byte[] call() throws Exception {
                Thread.sleep(1000);
                res.add("fdasfdas");
                res.add("hhh");
                return new String("aa bb cc").getBytes();
            }
        });




        System.out.println( res.size() + "----" );
        byte[] resultByte = (byte[]) futureTask.get();
        System.out.println( res.size() + "----" );
        String str = new String(resultByte);
        System.out.println( str );
    }
}
