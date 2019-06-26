package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 */

public interface UserServer {

    /**
     * 按照用户id返回用户地址
     * @param userid
     * @return
     */
    public List<UserAddress> getUserAddressList(String userid) throws InterruptedException;
}
