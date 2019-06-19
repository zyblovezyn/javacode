package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserServer;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/test/hello")
    public Object hello() {
        return "hello";
    }
/*

    @RequestMapping("/test/user")
    public Object getUserAddressByUserId() {
        return orderService.initOrder("ll");
    }
*/


    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(String userId){
        return orderService.initOrder(userId);
    }
}
