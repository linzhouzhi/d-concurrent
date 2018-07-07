package com.lzz.dconcurrent.demo;

import util.dconcurrent.DCallable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gl49 on 2018/7/4.
 */
public class TestCallableBoolean extends DCallable<List<String>> {

    public TestCallableBoolean(){}

    @Override
    protected List<String> call() {
        List<String> res = new ArrayList<String>();
        res.add("hello");
        res.add("good concurrent");
        return res;
    }
}