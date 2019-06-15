package com.mail.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxConfigTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);

        userService.insertUser();


        annotationConfigApplicationContext.close();
    }


}