package org.example.padrões;

public class SingletonControlPass {

    private static SingletonControlPass instance;
    private int controlPass;

    private SingletonControlPass(int start) {
        this.controlPass = start;
    }

    public static SingletonControlPass getInstance() {
        if (instance == null) {
            instance = new SingletonControlPass(10);
        }
        return getInstance();
    }

    public int getNext() {
        return this.controlPass ++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getInstance().getNext());
        }
    }

}
