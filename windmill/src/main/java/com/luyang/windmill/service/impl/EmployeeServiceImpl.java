package com.luyang.windmill.service.impl;

import com.luyang.windmill.bean.Employee;
import com.luyang.windmill.mapper.EmployeeMapper;
import com.luyang.windmill.service.EmployeeService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;


@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Resource
   EmployeeMapper employeeMapper;

    @Override
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }
}
