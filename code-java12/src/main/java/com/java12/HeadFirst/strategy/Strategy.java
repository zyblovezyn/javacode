package com.java12.HeadFirst.strategy;

import java.util.concurrent.CountDownLatch;

/**
 * @author zyb
 * @title: Strategy
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/25 0025 21:07
 */
public class Strategy {
    public static void main(String[] args) {
        Counsumer counsumer=new Counsumer();
        counsumer.pay(PayType.ALIPAY,100);
    }
}

interface ICommonPay {
    void pay(Integer money);
 }

class AliPay implements ICommonPay {
    @Override
    public void pay(Integer money) {
        System.out.println("alipay pay......."+"  "+money);
    }
}

class WxPay implements ICommonPay {
    @Override
    public void pay(Integer money) {
        System.out.println("weixin pay..........."+"   "+money);
    }
}

class Union implements ICommonPay {
    @Override
    public void pay(Integer money) {
        System.out.println("union pay.........."+"    "+money);
    }
}

class Counsumer{
    public void pay(PayType payType,Integer money){
        payType.getPay().pay(money);
    }
}

enum PayType {
    ALIPAY(new AliPay()),
    WXXINPAY(new WxPay()),
    UNIONPAY(new Union());

    private ICommonPay commonPay;

    PayType(ICommonPay commonPay) {
        this.commonPay = commonPay;
    }

    public ICommonPay getPay(){
        return this.commonPay;
    }
}
