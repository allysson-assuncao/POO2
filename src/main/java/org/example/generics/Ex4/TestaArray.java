package org.example.generics.Ex4;

public class TestaArray {
    public static void main(String[] args) {
        Pair<Integer>[] arr = new Pair[] {
                new Pair<>(1, 5),
                new Pair<>(3, 2),
                new Pair<>(2, 8),
                new Pair<>(1, 2),
        };
        ArrayAlg<Integer> aa = new ArrayAlg<>(arr);
        System.out.println("Min: " + aa.getMin());
        System.out.println("Max: " + aa.getMax());
    }
}
