package com.luyang.windmill.mapper;

import com.luyang.windmill.bean.Employee;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeMapper {

    Employee selectById(Integer id);
}
