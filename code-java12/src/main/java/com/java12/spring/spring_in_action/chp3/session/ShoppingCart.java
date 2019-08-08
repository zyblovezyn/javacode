package com.java12.spring.spring_in_action.chp3.session;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: ShoppingCart
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/7 0007 23:39
 */
@Component
@Scope(
        value = "session",
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class ShoppingCart {

}
