package com.bjsxt.springboothello.session;

import com.bjsxt.springboothello.bean.Emploee;

/**
 * @author zyb
 * @title: ISessionBean
 * @projectName springboot-hello
 * @description: TODO
 * @date 2019/8/8 0008 0:06
 */
public interface ISessionBean {

    void printId();
    Emploee getEmployee();
    void printEmployee();

}
