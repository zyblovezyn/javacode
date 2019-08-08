package com.java12.spring.spring_in_action.chp3.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: StoreService
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/7 0007 23:37
 */
@Component
public class StoreService {

    private ShoppingCart cart;

    public ShoppingCart getCart() {
        return cart;
    }

    @Autowired
    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
