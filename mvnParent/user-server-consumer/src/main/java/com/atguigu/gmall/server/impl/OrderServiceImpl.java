package com.atguigu.gmall.server.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserServer;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired

    @Reference
    UserServer UserServer;

    @Override
    public List<UserAddress> initOrder(String userid) {
        // 查询用户订单
        System.out.println("用户ID");
        List<UserAddress> list = UserServer.getUserAddressList(userid);
     /*   for (UserAddress userAddress : list) {
            System.out.println(userAddress);
        }*/
        return list;
    }
}
