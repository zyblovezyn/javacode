package com.luoyiguren.dubbo.userserviceconsumerboot.controllers;

import bean.UserAddress;
import com.luoyiguren.dubbo.userserviceconsumerboot.service.impl.OrderService;
import com.luoyiguren.dubbo.userserviceconsumerboot.service.impl.OrderServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        if(StringUtils.isEmpty(userId)){
            return null;
        }
        return orderService.initOrder(userId);
    }
}
