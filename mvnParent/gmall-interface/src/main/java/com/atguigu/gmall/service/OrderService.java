package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public List<UserAddress> initOrder(String userid);
}
