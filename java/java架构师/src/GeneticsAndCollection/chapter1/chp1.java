package chapter1;

import java.util.Arrays;
import java.util.List;

public class chp1 {
    public static void main(String[] args) {
        List<Integer> ints=Arrays.asList(1,2,3,4);
        int s=0;
        for (int m:ints){
            s+=m;
        }
        System.out.println(s);

    }
}
