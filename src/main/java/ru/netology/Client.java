package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final int PORT = 8080;
    private static final String HOST = "127.0.0.1";


    public static void main(String[] arg) {
//        final String name = "Маруся";
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // поток выхода
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) // поток
        {
            if (in.readLine().equals("???")) {
                out.println("москва");
                System.out.println("москва");
                System.out.println(in.readLine());
            } else {
                out.println("пушкин");
                System.out.println("пушкин");
//                out.println("армавир");
//                System.out.println("армавир");
//                out.println(("ростов"));
//                System.out.println("ростов");
                System.out.println(in.readLine());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}