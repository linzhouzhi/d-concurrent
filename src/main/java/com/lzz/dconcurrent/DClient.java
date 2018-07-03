package com.lzz.dconcurrent;

import java.util.concurrent.Callable;

/**
 * Created by lzz on 2018/3/26.
 */
public class DClient {
    public static void  submit(Runnable runnable){
        Class<?> classstr = runnable.getClass();
        System.out.println( classstr.getName() );
    }

    public static void  submit(Callable callable){
        Class<?> classstr = callable.getClass();
        System.out.println( classstr );
    }
}
