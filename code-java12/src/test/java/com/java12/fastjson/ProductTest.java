package com.java12.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: ProductTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/26 0026 22:55
 */
public class ProductTest {

    @Test
    public void test(){
        Product product=new Product();
        product.setProductName("产品");
        product.setDesc("这是一个产品");
        product.setPrice("22.3");

        String jsonstr=JSONObject.toJSONString(product);
        System.out.println(jsonstr);
        jsonstr=jsonstr.toUpperCase();
        System.out.println(jsonstr);

        product=JSONObject.toJavaObject(JSONObject.parseObject(jsonstr),Product.class);
        System.out.println(product.toString());
    }

}