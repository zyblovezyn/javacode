package com.mail.socketIO.socketio_01;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 8765;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("server start...");
            //进行阻塞
           /* Socket socket = serverSocket.accept();
            new Thread(new ServerHandler(socket)).start();*/
            HandlerExectorPool exectorPool = new HandlerExectorPool(50, 1000);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                exectorPool.execute(new ServerHandler(socket));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
