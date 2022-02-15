package com.nio;

/**
 * 启动类
 */
public class TimeServer {

    public static void main(String args[]){
        int port = 9816;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"nit").start();
    }
}
