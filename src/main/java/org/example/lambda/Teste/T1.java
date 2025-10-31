package org.example.lambda.Teste;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.Instant;

public class T1 {

    public static void main(String[] args) {

        ActionListener listener = event -> System.out.println("The time is: " + Instant.ofEpochMilli(event.getWhen()));
        new Timer(1000, listener).start();
        for(long j = 0; j < 99999; j++){
            for(long i = 0; i < 99999; i++){
                i--;
            }
        }

    }

}
