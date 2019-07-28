package com.java12.streampackage.p19;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamTest19Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 16:44
 */
public class StreamTest19Test {

    List<Student> list;

    @Before
    public void setUp() throws Exception {
        Student student1=new Student("zhangsan",20,"洛阳");
        Student student2=new Student("lisi",23,"郑州");
        Student student3=new Student("wangwu",21,"洛阳");
        Student student4=new Student("zhaosi",24,"洛阳");

        list=new ArrayList<>() ;
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
    }

    /**
     * 找出地址是 洛阳 年龄大于18 并且按年龄排序的student 输出student的名字
     */
    @Test
    public void streamTest() {
        list.stream().filter(x->
                StringUtils.endsWithIgnoreCase(x.getAddress(),"洛阳")
                        &&x.getAge()>18).sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();        //从小到大排序
                //return o1.getAge()-o2.getAge();       //从大到小排序

            }
        }).forEach(x-> System.out.println(x.getName()+"  "+x.getAge()));

    }
}