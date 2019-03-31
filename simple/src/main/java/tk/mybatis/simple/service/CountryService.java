package tk.mybatis.simple.service;

import tk.mybatis.simple.model.Country;

import java.util.List;

public interface CountryService {
    public List<Country> selectAll();

    public int update();

    public Country selectById(long id);
}
