package com.atguigu.gmall.server.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserServer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired

    @Reference(timeout = 5000, retries = 1, stub = "com.atguigu.gmall.server.UserServiceStub")
    UserServer userServer;

    @Override
    public List<UserAddress> initOrder(String userid) throws InterruptedException {
        System.out.println("-------------- 1 号被调用了-------------------");
        List<UserAddress> list = userServer.getUserAddressList(userid);
        return list;
    }
}
