package com.mail.concurrent.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnsafePulic {

    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePulic unsafePulic=new UnsafePulic();
        log.info("{}",Arrays.toString(unsafePulic.getStates()));

        unsafePulic.getStates()[0]="d";
        log.info("{}",Arrays.toString(unsafePulic.getStates()));
    }
}
