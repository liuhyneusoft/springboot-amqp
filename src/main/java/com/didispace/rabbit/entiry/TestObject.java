package com.didispace.rabbit.entiry;

import java.io.Serializable;

/**
 * Created by liuhaiyang on 2017/3/15.
 */
public class TestObject implements Serializable{
    private String name;
    private String age;
    public TestObject(String name,String age){
        this.name = name;
        this.age = age;

    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
