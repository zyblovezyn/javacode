package com.dubbo.springboot.service;

import com.dubbo.springboot.model.User;

public interface UserService {

    public String sayHello(String name);

    public User getUser(int id);
}
