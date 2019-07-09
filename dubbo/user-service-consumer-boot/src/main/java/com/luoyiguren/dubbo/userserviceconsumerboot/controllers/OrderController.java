package com.luoyiguren.dubbo.userserviceconsumerboot.controllers;

import bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrderService;

import java.util.List;

/**
 * @author Administrator
 * @title: controller
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/9 000923:17
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(String userId) {
        return orderService.initOrder(userId);
    }
}
