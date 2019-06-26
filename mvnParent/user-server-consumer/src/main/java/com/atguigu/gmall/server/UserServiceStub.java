package com.atguigu.gmall.server;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserServer;
import org.springframework.util.StringUtils;

import java.util.List;

// 远程接口本地存根
public class UserServiceStub implements UserServer {

    private final UserServer userServer;

    /**
     * 传入UserService远程代理
     * @param userServer
     */
    public UserServiceStub(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userid) throws InterruptedException {
        System.out.println("stub-------------------");
        if(!StringUtils.isEmpty(userid)){
            return userServer.getUserAddressList(userid);
        }
        return null;
     }
}
