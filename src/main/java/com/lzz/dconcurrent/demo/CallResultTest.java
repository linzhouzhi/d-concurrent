package com.lzz.dconcurrent.demo;


/**
 * Created by gl49 on 2018/7/4.
 */
public class CallResultTest{
    private int age = 19;
    private String name = "hello linzhouzhi";
    private Integer height = 100;

    public CallResultTest(int age, String name, Integer height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "CallResultTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
