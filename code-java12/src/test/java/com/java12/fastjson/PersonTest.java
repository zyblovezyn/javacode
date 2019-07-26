package com.java12.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: PersonTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/26 0026 22:28
 */
public class PersonTest {

    private Person person;

    /*
    初始化对象
     */
    @Before
    public void setUp(){
        person=new Person();
        person.setAge("20");
        person.setName("zhangsan");
        person.setDesc("这是一个测试");
    }

    @Test
    public void test(){
        String jsonstr=JSONObject.toJSONString(person);
        System.out.println("bean to json:"+jsonstr);

        // 改变json的key为大写
        jsonstr=jsonstr.toUpperCase();
        System.out.println("需要转换的json: "+jsonstr);

        person=JSONObject.toJavaObject(JSONObject.parseObject(jsonstr),Person.class);
        System.out.println("json to bean : "+person.getName());
    }
}