package com.java12.spring.spring_in_action.chp2;

import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: SgtPeppers
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 22:14
 */
@Component("sgtPeppers")
public class SgtPeppers implements CompactDisc {

    private String title="Sgt . Pepper's Lonely Hearts Club Band";
    private String artist="The Beatles";


    @Override
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
    }
}
