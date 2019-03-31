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

    @Transactional
    @Override
    public List<Country> selectAll() {
        return countryMapper.selectAll();
    }
}
