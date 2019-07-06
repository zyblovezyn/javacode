package com.java12.transientTest;

import java.io.*;

/**
 * @description 使用transient关键字不序列化某个变量
 *        注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 *
 * @author Alexia
 * @date  2013-10-15
 */
public class test {
    public static void main(String[] args) {

        User user=new User();
        user.setUsername("Alexia");
        user.setPassword("123456");

        System.out.println("read begore serializable:");
        System.out.println("username: "+user.getUsername());
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
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("C:/user.txt"));
            user=(User)is.readObject();
            is.close();

            System.out.println("\n read after serializable!");
            System.out.println("username: "+user.getUsername());
            System.out.println("password: "+user.getPassword());
            //System.out.println("username: "+user.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class User implements Serializable{
    private static final long serialVersionUID= 8294180014912103005L;
    private String username;
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
