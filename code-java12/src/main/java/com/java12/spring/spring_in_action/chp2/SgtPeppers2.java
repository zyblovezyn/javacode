package com.java12.spring.spring_in_action.chp2;

import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * @author zyb
 * @title: SgtPeppers
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 22:14
 */
//@Named("lonlyHeatsClub") //使用java自带的注解Named指定名称
//推荐使用@Component注解
    @Component("sgtPeppers2")
public class SgtPeppers2 implements CompactDisc {

    private String title = "Sgt . Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";


    @Override
    public void play() {
        System.out.println(" SgtPeppers2 Playing " + title + " by " + artist);
    }
}
