package service;

import bean.UserAddress;

import java.util.List;

/**
 * @author Administrator
 * @title: orderService
 * @projectName user-service-consumer
 * @description: TODO
 * @date 2019/7/9 000922:23
 */
public interface OrderService {
    public List<UserAddress> initOrder(String userId);
}
