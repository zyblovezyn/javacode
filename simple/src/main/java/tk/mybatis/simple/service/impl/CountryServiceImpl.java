package tk.mybatis.simple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.service.CountryService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CountryServiceImpl implements CountryService  {

    @Resource
    private CountryMapper countryMapper;

    @Transactional //表示这个方法开启事务
    @Override
    public List<Country> selectAll()
    {
        return countryMapper.selectAll();
    }

    @Transactional //10/0 抛出异常查看是否回滚
    @Override
    public int update() {
        Country country=new Country();
        country.setId((long) 1);
        country.setCountryname("美国-update");
        countryMapper.update(country);
        int i=10/0;

        return 0;
    }
}
