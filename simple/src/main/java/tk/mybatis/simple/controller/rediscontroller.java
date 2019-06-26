package tk.mybatis.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.simple.redis.RedisMethod;


@RestController
public class rediscontroller {

    @Autowired
    private RedisMethod redisMethod;

    @RequestMapping("boot/test")
    public Object test(){
        redisMethod.test();
        return null;
    }

    @RequestMapping("boot/add")
    public Object add(){
        redisMethod.add();
        return "ok";
    }
}
