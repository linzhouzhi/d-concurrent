package com.lzz.dconcurrent.demo;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lzz on 2018/7/5.
 */
public class Test {
    public static  void main(String[] args){
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
