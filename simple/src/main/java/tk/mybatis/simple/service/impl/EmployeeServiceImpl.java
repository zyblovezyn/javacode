package tk.mybatis.simple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.mapper.EmployeeMapper;
import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.Employee;
import tk.mybatis.simple.service.CountryService;
import tk.mybatis.simple.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Resource
   EmployeeMapper employeeMapper;

    @Override
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }
}
