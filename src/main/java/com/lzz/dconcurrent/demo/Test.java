package com.lzz.dconcurrent.demo;

import util.dconcurrent.DExecutorsManager;

/**
 * Created by lzz on 2018/7/5.
 */
public class Test {
    public static  void main(String[] args) throws Exception {
        DExecutorsManager dExecutorsManager = new DExecutorsManager("D:/work/java/tmp/d-concurrent/target/classes/");
        dExecutorsManager.serverStart(50011);
    }
}
