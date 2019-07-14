package com.luoyiguren.dubbo.userserviceconsumerboot.service.impl;

import bean.UserAddress;
import org.springframework.util.StringUtils;
import service.UserService;

import java.util.List;

/**
 * @author Administrator
 * @title: OrderService
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/10 001021:47
 */
public class OrderServiceStub implements UserService{

    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("com.luoyiguren.dubbo.userserviceconsumerboot.service.impl.OrderServiceStub");
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        return userService.getUserAddress(userId);
    }

    private final UserService userService;


    // 传入的是远程代理对象
    public OrderServiceStub(UserService userService) {
        this.userService = userService;
    }
}
