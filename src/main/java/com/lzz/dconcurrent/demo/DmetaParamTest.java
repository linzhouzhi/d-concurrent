package com.lzz.dconcurrent.demo;

import util.dconcurrent.DmetaParam;

/**
 * Created by gl49 on 2018/7/4.
 */
public class DmetaParamTest extends DmetaParam {
    String name = "hello";
    int age = 123;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DmetaParamTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
