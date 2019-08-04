package com.java12.spring.spring_in_action.chp2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: CDPlayerConfigTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 22:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerConfigTest {

    @Qualifier("sgtPeppers2")
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void setCompactDisc() {
        assertNotNull(compactDisc);
        System.out.println();
        System.out.println("--------------" + compactDisc);
        compactDisc.play();
        System.out.println();
    }

}