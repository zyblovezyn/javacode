package com.atguigu.gmall.mapper;

import com.atguigu.gmall.bean.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressMapper {

    public List<UserAddress> getUserAddressList(String userid);
}
