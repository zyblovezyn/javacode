package com.mail.concurrent.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

@Slf4j
public class VectorExample3 {

    private static void test1(Vector v1){
        for (Object integer:v1){
            if(integer.equals(3)){
                v1.remove(3);
            }
        }
    }
    private static void test2(Vector v1){
        Iterator<Integer> integerIterator=v1.iterator();
        while (integerIterator.hasNext()){
            Integer value=integerIterator.next();
            if(value.equals(3)){
                v1.remove(3);
            }
        }
    }
    private static void test3(Vector v1){
        for(int i=0;i<v1.size();i++){
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
//        test1(vector);
        //test2(vector);
        test3(vector);
    }
}
