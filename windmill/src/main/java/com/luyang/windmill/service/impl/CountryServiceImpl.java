package com.luyang.windmill.service.impl;

import com.luyang.windmill.bean.Country;
import com.luyang.windmill.mapper.CountryMapper;
import com.luyang.windmill.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;


@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    private CountryMapper countryMapper;


    @Transactional //表示这个方法开启事务
    @Override
    public List<Country> selectAll() {
        return null;
    }

    @Transactional //10/0 抛出异常查看是否回滚
    @Override
    public int update() {
        return 0;
    }

    @Override
    public Country selectById(long id) {
        return countryMapper.selectById(id);
    }
}
