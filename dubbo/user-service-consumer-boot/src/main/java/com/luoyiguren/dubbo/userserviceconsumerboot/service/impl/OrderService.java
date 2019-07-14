package com.luoyiguren.dubbo.userserviceconsumerboot.service.impl;

import bean.UserAddress;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.UserService;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author zyb
 * @title: OrderServer
 * @projectName user-service-provider-boot
 * @description: TODO
 * @date 2019/7/14 0014 9:44
 */

@Service
public class OrderService {



    @Reference(retries = 0)
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        return userService.getUserAddress(userId);
    }

}
