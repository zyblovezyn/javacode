package com.java12.spring.spring_in_action.chp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: CDPlayer
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/6 0006 23:03
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

}
