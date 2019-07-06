package com.java12.transientTest;

import java.io.*;

/**
 * @description 使用transient关键字不序列化某个变量
 *        注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 *   反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
 * @author Alexia
 * @date  2013-10-15
 */
public class test1 {
    public static void main(String[] args) {

        User1 user=new User1();
        user.setUser1name("Alexia");
        user.setPassword("123456");

        System.out.println("read begore serializable:");
        System.out.println("username: "+user.getUser1name());
        System.out.println("password: "+user.getPassword());

        try {
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            user.setUser1name("zyb");
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("C:/user.txt"));
            user=(User1)is.readObject();
            is.close();

            System.out.println("\n read after serializable!");
            System.out.println("username: "+user.getUser1name());
            System.out.println("password: "+user.getPassword());
            //System.out.println("username: "+user.getUser1name());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class User1 implements Serializable{
    private static final long serialVersionUID= 8294180014912103005L;
    private static String username;
    private transient String password;

    public String getUser1name() {
        return username;
    }

    public void setUser1name(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
