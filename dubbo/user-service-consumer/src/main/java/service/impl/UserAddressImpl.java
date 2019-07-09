package service.impl;

import bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;
import service.UserService;

import java.util.List;

/**
 * @author Administrator
 * @title: UserAddressImpl
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/9 000922:13
 */

@Service
public class UserAddressImpl implements OrderService {


    @Autowired
    UserService userService;

    public void initOrder(String userId) {
        System.out.println("用户ID： "+userId);
        List<UserAddress> list=userService.getUserAddress(userId);
        for (UserAddress userAddress:list){
            System.out.println(userAddress);
        }
    }
}
