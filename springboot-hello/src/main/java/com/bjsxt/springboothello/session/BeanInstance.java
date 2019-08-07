package com.bjsxt.springboothello.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zyb
 * @title: BeanInstance
 * @projectName springboot-hello
 * @description: TODO
 * @date 2019/8/8 0008 0:09
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanInstance {

    @Autowired
    private IRequestBean requestBean;

    @Autowired
    private ISessionBean sessionBean;

    public IRequestBean getRequestBean() {
        return requestBean;
    }

    public ISessionBean getSessionBean() {
        return sessionBean;
    }
}
