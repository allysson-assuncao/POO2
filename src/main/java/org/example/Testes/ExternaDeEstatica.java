package org.example.Testes;

public class ExternaDeEstatica {
    private static int x = 10;

    public static void main(String[] args) {

        class Interna{

            public void veExterna(){
                System.out.println("x: " + x);
            }
        }
        new Interna().veExterna();
    }


}
