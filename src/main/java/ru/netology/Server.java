package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] arg) {
        String currentCity = null;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("New connection accepted");
                    if (currentCity == null) {
                        out.println("???");
                        currentCity = in.readLine();
                        System.out.println("current city: " + currentCity);
                        out.println("OK");
                    } else {
                        out.println(currentCity);
                        System.out.println("current city: " + currentCity);
                        String city = in.readLine();
                        System.out.println("input city: " + city);
                        String strLast = currentCity.substring(currentCity.length() - 1);
                        String strFirst = city.substring(0, 1);
                        if (strLast.equals(strFirst)) {
                            out.println("OK");
                            currentCity = city;
                            System.out.println("current city: " + currentCity);
                        } else {
                            out.println("NOT OK");
                            System.out.println("current city: " + currentCity);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
