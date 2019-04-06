package tk.mybatis.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.simple.service.CountryService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableTransactionManagement //开启springboot事务支持
@RestController
public class CountryController{

    @Autowired
    protected CountryService countryService;

    @RequestMapping("/boot/selectAll")
    public Object selectAll(){

        //多线程测试缓存穿透问题
        ExecutorService executorServive=Executors.newFixedThreadPool(5);

        for (int i=0;i<10000;i++){
            executorServive.submit(new Runnable() {
                @Override
                public void run() {
                    countryService.selectAll();
                }
            });
        }

        return countryService.selectAll();
    }
    @RequestMapping("/boot/update")
    public Object update(){
        return countryService.update();
    }
}
