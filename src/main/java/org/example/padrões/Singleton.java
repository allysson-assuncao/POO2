package org.example.padrões;

public class Singleton {

    private static Singleton instance;
    private int sequencia = 0;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return getInstance();
    }

    public static int getNext() {
        return getInstance().sequencia++;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getNext());
    }

}
