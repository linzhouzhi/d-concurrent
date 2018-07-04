package com.lzz.dconcurrent.demo;

import com.lzz.dconcurrent.DCallable;
import com.lzz.dconcurrent.DmetaParam;

/**
 * Created by gl49 on 2018/7/4.
 */
public class TestCallable extends DCallable<CallResultTest> {
    DmetaParamTest dmetaParamTest;

    public TestCallable(){}
    public TestCallable(DmetaParam dmetaParam){
        this.dmetaParamTest = (DmetaParamTest) dmetaParam;
    }

    @Override
    protected CallResultTest call() {
        int count = this.dmetaParamTest.age;
        CallResultTest callResultTest = new CallResultTest(12321, "hello call test....", 200 + count);
        System.out.println( callResultTest );
        return callResultTest;
    }
}