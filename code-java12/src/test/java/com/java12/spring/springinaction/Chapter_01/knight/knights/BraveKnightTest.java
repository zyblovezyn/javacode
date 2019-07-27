package com.java12.spring.springinaction.Chapter_01.knight.knights;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * @author zyb
 * @title: BraveKnightTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 0:03
 */
public class BraveKnightTest {
    @Test
    public void kinghtShouldEmbarkOnQuest(){
        Quest mockQuest=mock(Quest.class);

        BraveKnight knight=new BraveKnight(mockQuest);

        knight.embarkOnQuest();
        System.out.println("111111111111");
        verify(mockQuest,timeout(1)).embark();
    }

}