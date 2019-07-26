package com.java12.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zyb
 * @title: Product
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/26 0026 22:51
 */
public class Product {

    private String productName;
    private String desc;
    private String price;

    @JSONField(name = "name1")
    public String getProductName() {
        return productName;
    }
    @JSONField(name = "NAME1")
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @JSONField(name = "desc1")
    public String getDesc() {
        return desc;
    }
    @JSONField(name = "DESC1")
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @JSONField(name = "price1")
    public String getPrice() {
        return price;
    }
    @JSONField(name = "PRICE1")
    public void setPrice(String price) {
        this.price = price;
    }

    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
