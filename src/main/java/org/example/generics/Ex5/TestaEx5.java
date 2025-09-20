package org.example.generics.Ex5;

public class TestaEx5 {
    public static void main(String[] args) {
        StringPair sp = new StringPair("x", "yz");
        System.out.println("StringPair: " + sp);
        System.out.println("totalLength: " + sp.totalLength());

        Pair<String> p = new Pair<>("a", "b");
        System.out.println("Pair<String>: " + p);

        // Demonstração de invariância
        // Pair<Object> po = new Pair<String>("a", "b"); // incompatible types
    }
}
