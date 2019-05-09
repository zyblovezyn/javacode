package com.mail.concurrent.UseExecutor;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {

    private int id;
    private String name;

    public MyTask(int taskId, String taskName) {
        this.id = taskId;
        this.name = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("run taskid=" + this.id);
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
