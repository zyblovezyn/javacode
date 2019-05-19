package com.mail.JDK.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {

        FunctionTest test=new FunctionTest();

        System.out.println(test.compute(2,value->{return value/3;},value->{
            return value*value;
        }));
        System.out.println(test.compute2(2,value->{return value/3;},value->{
            return value*value;
        }));


        System.out.println(test.compute3(1,2,(x,y)->{return x+y;}));

        System.out.println(test.compute3(1,2,(x,y)->{
            return x-y;
        }));
        System.out.println(test.compute3(1,2,(x,y)->x*y));

        System.out.println(test.compute3(1,2,(x,y)->x/y));


        System.out.println(test.compute4(2,3,(x,y)->x+y,x->x*x));

    }

    public int compute(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }
    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }

    public int compute4(int a,int b,BiFunction<Integer,Integer,Integer> function,
                        Function<Integer,Integer> function1){
        return function.andThen(function1).apply(a,b);
    }
}
