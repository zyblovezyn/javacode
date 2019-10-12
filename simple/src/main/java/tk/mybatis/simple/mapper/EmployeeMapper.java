package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.simple.model.Employee;

import java.io.InputStream;


@Mapper
public interface EmployeeMapper {

    Employee selectById(Integer id);
}
