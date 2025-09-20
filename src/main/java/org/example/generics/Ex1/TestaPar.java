package org.example.generics.Ex1;

public class TestaPar {

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Alice", 30);
        System.out.println("p1 first (String): " + p1.getFirst());
        System.out.println("p1 second (Integer): " + p1.getSecond());

        p1.setFirst("Bob");
        p1.setSecond(25);
        System.out.println("p1 após setFirst/setSecond: (" + p1.getFirst() + ", " + p1.getSecond() + ")");

        Pair<Double, String> p2 = new Pair<>();
        p2.setFirst(3.1415);
        p2.setSecond("pi");
        System.out.println("p2: (" + p2.getFirst() + ", " + p2.getSecond() + ")");

        Pair<Integer, Boolean> p3 = new Pair<>(1, true);
        System.out.println("p3: (" + p3.getFirst() + ", " + p3.getSecond() + ")");
    }

}
