package com.java12.spring.spring_in_action.componentTest;

import com.java12.spring.spring_in_action.chp2.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: SgtPeppers
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 22:14
 */
@Component
public class SgtPeppers3 implements CompactDisc {

    private String title="Sgt . Pepper's Lonely Hearts Club Band";
    private String artist="The Beatles";


    @Override
    public void play() {
        System.out.println("SgtPeppers3 Playing "+title+" by "+artist);
    }
}
