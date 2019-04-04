package tk.mybatis.simple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.service.CountryService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CountryServiceImpl implements CountryService {

    @Resource
    private CountryMapper countryMapper;

    /*    注入springboot自动配置好的redistemplate*/
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Transactional //表示这个方法开启事务
    @Override
    public List<Country> selectAll() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //在高并发环境下，此处有点问题 缓存穿透
        List<Country> countryList = (List<Country>) redisTemplate.opsForValue().get("allCountry");

        if (countryList == null) {
            synchronized (this) {
                // 从redis获取
                countryList = (List<Country>) redisTemplate.opsForValue().get("allCountry");
                if (countryList == null) {
                    System.out.println("查询数据库");
                    countryList = countryMapper.selectAll();
                    redisTemplate.opsForValue().set("allCountry", countryList);
                    return countryList;
                }else{
                    System.out.println("查询缓存");
                }
            }
        }else{
            System.out.println("查询缓存");
        }
        return countryList;
    }

    @Transactional //10/0 抛出异常查看是否回滚
    @Override
    public int update() {
        Country country = new Country();
        country.setId((long) 1);
        country.setCountryname("美国-update");
        countryMapper.update(country);
        int i = 10 / 0;

        return 0;
    }

    @Override
    public Country selectById(long id) {
        return countryMapper.selectById(id);
    }
}
