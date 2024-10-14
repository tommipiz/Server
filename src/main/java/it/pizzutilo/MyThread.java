package it.pizzutilo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{
    private Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            System.out.println("Qualcuno si è collegato");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringRicevuta;
            do {
                stringRicevuta = in.readLine();
                if (stringRicevuta.equals("0")) {
                    System.out.println("Comunicazione terminata");
                } else {
                    System.out.println("La stringa ricevuta: " + stringRicevuta + "\n");
                    out.writeBytes(stringRicevuta.toUpperCase() + "\n");
                }

            } while(!stringRicevuta.equals("0"));
            
        } catch (IOException e) {
            System.out.println("Errore");
        }
        
   
    }



}
