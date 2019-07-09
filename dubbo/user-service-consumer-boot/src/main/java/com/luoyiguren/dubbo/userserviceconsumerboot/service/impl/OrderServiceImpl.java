package com.luoyiguren.dubbo.userserviceconsumerboot.service.impl;

import bean.UserAddress;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;
import service.UserService;

import java.util.List;

/**
 * @author Administrator
 * @title: UserAddressImpl
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/9 000922:13
 */

@Service
public class OrderServiceImpl implements OrderService {


    @Reference
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户ID： " + userId);
        List<UserAddress> list = userService.getUserAddress(userId);
        return list;
    }
}
