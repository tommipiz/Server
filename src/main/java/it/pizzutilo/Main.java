package it.pizzutilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss2 = new ServerSocket(5672);
        do {
            Socket s2 = ss2.accept();
            MyThread t = new MyThread(s2);
            t.run();
        } while(true);

    }
    
}