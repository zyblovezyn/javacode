package com.java12.transientTest;

import java.io.*;

/**
 * @author Alexia
 * @description 使用transient关键字不序列化某个变量
 * 注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 * 反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
 * @date 2013-10-15
 */

class ExternalizableTest implements Externalizable {

    private transient String content = "是的，我将被序列化！";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {
        ExternalizableTest et = new ExternalizableTest();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (ExternalizableTest) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }
}
