package com.mail.concurrent.connThreadLocal;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> cow1 = new CopyOnWriteArrayList<>();
        cow1.add("ass");
    }


}
