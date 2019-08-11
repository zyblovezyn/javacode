package tk.mybatis.simple.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.simple.model.Employee;
import tk.mybatis.simple.service.EmployeeService;


//@EnableTransactionManagement //开启springboot事务支持
@RestController
@RequestMapping("/EmployeeController")
public class EmployeeController {

    @Autowired
    protected EmployeeService employeeService;

    @RequestMapping(value = "/selectById")
    public @ResponseBody Employee selectById(Integer id) {
        return employeeService.selectById(id);
    }

}
