package com.bjsxt.springboothello.controller;

import com.bjsxt.springboothello.session.BeanInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zyb
 * @title: UserController
 * @projectName springboot-hello
 * @description: TODO
 * @date 2019/8/8 0008 0:11
 */
@RestController
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private BeanInstance beanInstance1;
    @Autowired
    private BeanInstance beanInstance2;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String name) {
        System.out.println("SessionBean-1");
        beanInstance1.getSessionBean().printId();

        if (beanInstance1.getSessionBean().getEmployee().getName() == null) {
            beanInstance1.getSessionBean().getEmployee().setId(12L);
            beanInstance1.getSessionBean().getEmployee().setName("zhangsan");
        }

        if (beanInstance2.getRequestBean().getEmployee().getName() == null) {
            beanInstance2.getRequestBean().getEmployee().setId(12L);
            beanInstance2.getRequestBean().getEmployee().setName("zhangsan");
        }

        System.out.println(beanInstance1.getSessionBean().getEmployee());
        System.out.println(beanInstance2.getRequestBean().getEmployee());

        /*System.out.println("SessionBean-2");
        beanInstance2.getSessionBean().printId();
        System.out.println("RequestBean-1");
        beanInstance1.getRequestBean().printId();
        System.out.println("RequestBean-2");
        beanInstance2.getRequestBean().printId();*/
        return "user/check";
    }
}
