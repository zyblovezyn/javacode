package com.bjsxt.springboothello.session;

import com.bjsxt.springboothello.bean.Emploee;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

/**
 * @author zyb
 * @title: RequestBean
 * @projectName springboot-hello
 * @description: TODO
 * @date 2019/8/8 0008 0:06
 */
@Component
@Scope(
        value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.INTERFACES
)
public class RequestBean implements IRequestBean {
    private UUID uuid;
    private Emploee emploee=new Emploee();
    public RequestBean() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public void printId() {
        System.out.println("RequestBean:" + uuid);

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
