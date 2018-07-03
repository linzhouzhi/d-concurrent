package com.lzz.dconcurrent.util;

/**
 * Created by lzz on 2018/7/4.
 */
public class RunnableTest implements Runnable{
    private Integer count;
    public RunnableTest(Integer count){
        this.count = count;
    }
    @Override
    public void run() {
        System.out.println( "this count :" + this.count);
    }
}
