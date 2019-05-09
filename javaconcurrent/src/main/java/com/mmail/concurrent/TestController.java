package com.mmail.concurrent;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String Test(){
        return "test";
    }
}
