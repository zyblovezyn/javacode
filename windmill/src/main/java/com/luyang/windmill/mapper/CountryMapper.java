package com.luyang.windmill.mapper;

import com.luyang.windmill.bean.Country;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CountryMapper {
    public List<Country> selectAll();
    public int update(Country country);
    public Country selectById(long id);
}
