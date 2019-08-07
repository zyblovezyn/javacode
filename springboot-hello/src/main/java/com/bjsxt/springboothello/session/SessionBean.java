package com.bjsxt.springboothello.session;

import com.bjsxt.springboothello.bean.Emploee;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

/**
 * @author zyb
 * @title: SessionBean
 * @projectName springboot-hello
 * @description: TODO
 * @date 2019/8/8 0008 0:03
 */
@Component
@Scope(
        value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.INTERFACES
)
public class SessionBean implements ISessionBean {
    private UUID uuid;
    private Emploee emploee=new Emploee();

    public SessionBean() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public void printId() {
        System.out.println("SessionBean:" + uuid);

    }

    @Override
    public Emploee getEmployee() {
        return this.emploee;
    }

    @Override
    public void printEmployee() {
        this.emploee.toString();
    }
}
