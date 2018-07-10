package com.lzz.dconcurrent.demo;

import com.google.common.collect.Sets;
import util.dconcurrent.DExecutorsManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lzz on 2018/7/5.
 */
public class Test {
    public static  void main(String[] args) throws Exception {
        DExecutorsManager dExecutorsManager = new DExecutorsManager("D:/work/java/tmp/d-concurrent/target/classes/");
        dExecutorsManager.serverStart(50011);
    }
}
