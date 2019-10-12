package com.luyang.windmill.controller;

import com.luyang.windmill.bean.Employee;
import com.luyang.windmill.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



//@EnableTransactionManagement //开启springboot事务支持
@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    protected EmployeeService employeeService;

    @RequestMapping(value = "/selectById")
    public Employee selectById(Integer id) {
        return employeeService.selectById(id);
    }

}
