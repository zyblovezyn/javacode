package com.luyang.windmill.service;

import com.luyang.windmill.bean.Country;

import java.util.List;

public interface CountryService {
    public List<Country> selectAll();

    public int update();

    public Country selectById(long id);
}
