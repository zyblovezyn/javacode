package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.mapper.UserAddressMapper;
import com.atguigu.gmall.service.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@com.alibaba.dubbo.config.annotation.Service
@Service
public class UserServerImpl implements UserServer {

    @Resource
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> getUserAddressList(String userid) throws InterruptedException {

       /* UserAddress userAddress=new UserAddress();
        List<UserAddress> list=new ArrayList<>();
        list.add(userAddress);
        return list;*/
        System.out.println("UserServerImpl......old.....");
         return userAddressMapper.getUserAddressList(userid);
    }
}
