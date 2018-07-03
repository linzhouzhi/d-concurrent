package com.lzz.dconcurrent.util;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrent {
    public static List<String> res = new ArrayList<String>();
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        DConcurrentClient client = new DConcurrentClient("127.0.0.1",50052);
        List<String> arr = new ArrayList<String>();
        for(int i=0;i<5;i++){
            arr.add( "world:"+i );
        }

        client.submit(new Runnable() {
            public void run() {
                System.out.println( "zzz");
            }
        });


        FutureTask futureTask = client.submit(new Callable<byte[]>() {
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
