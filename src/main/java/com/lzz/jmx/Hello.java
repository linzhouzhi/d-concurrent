package com.lzz.jmx;

/**
 * Created by gl49 on 2018/4/19.
 */
public class Hello implements HelloMBean{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return null;
    }

    public void setAge(String age) {

    }

    public void helloWorld() {

    }

    public void helloWorld(String str) {
        System.out.println( str );
    }

    public void getTelephone() {

    }
}
