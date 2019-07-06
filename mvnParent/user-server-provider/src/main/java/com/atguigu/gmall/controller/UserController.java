package com.atguigu.gmall.controller;

import com.atguigu.gmall.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
@MapperScan("com.atguigu.gmall.mapper.*")
*/
public class UserController {

    @Autowired
    UserServer userServer;

    @RequestMapping("/test/hello")
    public Object hello() {
        return "hello";
    }

    @RequestMapping("/test/user")
    public Object getUserAddressByUserId() throws InterruptedException {
        return userServer.getUserAddressList("ll");
    }
}