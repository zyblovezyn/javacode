package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.mapper.UserAddressMapper;
import com.atguigu.gmall.service.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {


    @Resource
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> getUserAddressList(String userid) {
        return userAddressMapper.getUserAddressList(userid);
    }
}
