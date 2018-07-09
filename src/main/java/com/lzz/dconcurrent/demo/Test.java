package com.lzz.dconcurrent.demo;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lzz on 2018/7/5.
 */
public class Test {
    public static  void main(String[] args){
        List<String> liststr = new ArrayList();
        liststr.add("aaa");
        liststr.add("bbb");
        liststr.add("ccc");
        double tt = 3/(double)2;
        System.out.println( tt );
        System.out.println( liststr );

        String s = "";
        s.hashCode();

        Set listSet = new HashSet();
        listSet.add("aa");
        listSet.add("bb");
        listSet.add("dd");

        Set callCountSet = new HashSet();
        callCountSet.add("aa");
        callCountSet.add("bb");
        callCountSet.add("cc");
        callCountSet.add("cc6");
        Set listNotable = Sets.difference(callCountSet, listSet);
        System.out.println( listNotable );
    }
}
