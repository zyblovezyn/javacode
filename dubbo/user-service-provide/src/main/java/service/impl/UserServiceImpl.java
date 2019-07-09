package service.impl;

import bean.UserAddress;
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
public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddress(String userid) {
        UserAddress userAddress=new UserAddress();
        userAddress.setAddress("河南洛阳");
        List<UserAddress> list=new ArrayList<UserAddress>();
        list.add(userAddress);
        return list;
    }
}
