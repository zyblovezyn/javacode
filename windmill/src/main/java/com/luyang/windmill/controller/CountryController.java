package com.luyang.windmill.controller;

import com.luyang.windmill.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableTransactionManagement //开启springboot事务支持
@RestController
public class CountryController {

    @Autowired
    protected CountryService countryService;

    @RequestMapping("/boot/selectAll")
    public Object selectAll() {
        return countryService.selectAll();
    }

    @RequestMapping("/boot/update")
    public Object update() {
        return countryService.update();
    }
}
