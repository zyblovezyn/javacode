package tk.mybatis.dubboprovide.service.imp;

import com.dubbo.springboot.model.User;
import com.dubbo.springboot.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "hi springboot "+name;
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
