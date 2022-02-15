package com.tcp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpSocketClient {


    public static void main(String[] args) throws Exception{
        int port = 9818;
        Socket socket;
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入命令：");
            String cmdStr = scanner.nextLine();
            switch (cmdStr) {
                case "conn":
                    socket = new Socket("localhost", port);
                    in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);
                    System.out.println("已建立连接");
                    break;
                case "send":
                    System.out.println("请输入你需要发送的内容");
                    for (;;) {
                        String sendMsg = scanner.nextLine();
                        if ("exit".equals(sendMsg)) {
                            System.exit(-1);
                        } else {
                            sendMsg(in, out, sendMsg);
                        }
                    }
                case "exit":
                    System.exit(-1);
                    break;
                default:
                    break;
            }

        }
    }

    private static void  sendMsg(BufferedReader in,PrintWriter out,String msg) throws Exception{
        out.println(msg);
        String resp = in.readLine();
        System.out.println("服务器："+resp);
    }


}
