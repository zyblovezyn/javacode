package tk.mybatis.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.simple.mapper.CountryMapper;
import tk.mybatis.simple.service.CountryService;

import javax.annotation.Resource;

@EnableTransactionManagement //开启springboot事务支持
@RestController
public class CountryController {

    @Autowired
    protected CountryService countryService;

    @RequestMapping("/boot/selectAll")
    public Object selectAll(){
        return countryService.selectAll();
    }
    @RequestMapping("/boot/update")
    public Object update(){
        return countryService.update();
    }
}
