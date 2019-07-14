package service;

import bean.UserAddress;

import java.util.List;

/**
 * @author Administrator
 * @title: UserService
 * @projectName user-service-provide
 * @description: TODO
 * @date 2019/7/9 000922:02
 */
public interface UserService {

    List<UserAddress> getUserAddress(String userId);

}
