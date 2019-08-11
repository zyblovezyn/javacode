package tk.mybatis.simple.service;

import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee selectById(Integer id);
}
