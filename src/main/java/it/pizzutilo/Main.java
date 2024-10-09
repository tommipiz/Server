package it.pizzutilo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5637);
        Socket s = ss.accept();
        System.out.println("Qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringRicevuta;
        do {
            String stringRicevuta = in.readLine();
            if(stringRicevuta.equals("0")) {
                System.out.println("Comunicazione terminata");
            } else {
                System.out.println("La stringa ricevuta: " + stringRicevuta);
                out.writeBytes();
            }

        }while(stringRicevuta.equals(stringRicevuta));

        out.writeBytes("sono il Server" + "\n");

        s.close();
        ss.close();

    }
}