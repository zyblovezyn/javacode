package com.java12.spring.spring_in_action.chp3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * @author zyb
 * @title: ProductionProfileCOnfig
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/7 0007 21:13
 */

@Configuration
@Profile("prod")
public class ProductionProfileConfig {


    @Bean
    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean =
                new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(
                javax.sql.DataSource.class
        );
        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}
