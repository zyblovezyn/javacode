package com.luoyiguren.dubbo.userserviceproviderboot.dao;


import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @title: UserServiceDao
 * @projectName user-service-provider-boot
 * @description: TODO
 * @date 2019/7/10 001023:21
 */
@Mapper
public interface UserServiceMapper {
    String getAddress(String userId);
}
