package com.luoyiguren.dubbo.userserviceproviderboot.service.impl;

import bean.UserAddress;
import com.alibaba.dubbo.config.annotation.Service;
import com.luoyiguren.dubbo.userserviceproviderboot.dao.UserServiceMapper;
import org.springframework.stereotype.Component;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    UserServiceMapper userServiceMapper;

    public List<UserAddress> getUserAddress(String userId) {

       /* try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("-------------1------------------");
        String address = userServiceMapper.getAddress(userId);
        UserAddress userAddress = new UserAddress();
        userAddress.setAddress(address);
        List<UserAddress> list = new ArrayList<UserAddress>();
        list.add(userAddress);
        return list;
    }
}
