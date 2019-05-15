package com.mail.JunitTest;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("hello");
    }

    //抛出异常
    @Test(expected = java.lang.ArithmeticException.class,timeout = 100)
    //@Ignore 忽略
    public void divide(){
        T t=new T();
        int sum=t.divide(3,5);
        assertThat(sum,is(0));

    }

    @Test
    public void add() {
        T t=new T();
        int sum=t.add(3,5);

        // failures 测试失败
        // Erors 程序失败 出错

        /**
         * failures 测试失败
         * erors 程序失败 出错
         *
         */

        /*
        // 数值
        assertEquals(8,sum);
        assertTrue(4>3);
        assertTrue("sum too smalll",sum<10);
        assertThat(sum,is(8));
        assertThat(sum,allOf(greaterThan(1),lessThan(10)));
        assertThat(sum,anyOf(greaterThan(1),lessThan(10)));
        assertThat(sum,anything());
        assertThat(sum,is("bjsxt"));
        assertThat(sum,is(not("bjsxt")));

        //  字符串
        String str="dcwqfdeqf";
        assertThat(str,containsString("dshja"));
        assertThat(str,endsWith("dsjk"));
        assertThat(str,startsWith("ds"));
        assertThat(str,equalTo("dwde"));//比较对象 is 比较值
        assertThat(str,equalToIgnoringCase("dew"));
        assertThat(str,equalToIgnoringWhiteSpace("cdcd"));

        // double
        double d=10.2;
        double ass=3.0;
        double err=0.3;
        assertThat(d,closeTo(ass,err));
        assertThat(d,greaterThan(ass));
        assertThat(d,lessThan(ass));
        assertThat(d,greaterThanOrEqualTo(ass));
        assertThat(d,lessThanOrEqualTo(ass));

        // HashMap
        HashMap<String,String> assmap=new HashMap<>();
        assmap.put("as","as");
        assertThat(assmap,hasEntry("as","as"));
        assertThat(assmap,hasKey("as"));
        assertThat(assmap,hasValue("as"));
        */
     }
}