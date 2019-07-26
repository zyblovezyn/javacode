package com.java12.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zyb
 * @title: Person
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/26 0026 22:24
 */
public class Person {

    @JSONField(name = "name1")
    private String name;

    @JSONField(name = "age1")
    private String age;

    @JSONField(name = "desc1")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
