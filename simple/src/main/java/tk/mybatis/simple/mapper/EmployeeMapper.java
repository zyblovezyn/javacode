package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.simple.model.Employee;

import java.io.InputStream;


@Mapper
public interface EmployeeMapper {

    Employee selectById(Integer id);
}
