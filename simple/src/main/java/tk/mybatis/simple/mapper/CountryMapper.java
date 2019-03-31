package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.simple.model.Country;
import java.util.List;

@Mapper
public interface CountryMapper {
    public List<Country> selectAll();
}
