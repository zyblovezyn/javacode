package com.luoyiguren.dubbo.userserviceproviderboot.service.impl;

import bean.UserAddress;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: UserServiceImpl
 * @projectName user-service-provide
 * @description: TODO
 * @date 2019/7/9 000922:04
 */

@Service //暴露服务
@Component
public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddress(String userid) {
        UserAddress userAddress=new UserAddress();
        userAddress.setAddress("河南洛阳");
        List<UserAddress> list=new ArrayList<UserAddress>();
        list.add(userAddress);
        return list;
    }
}
