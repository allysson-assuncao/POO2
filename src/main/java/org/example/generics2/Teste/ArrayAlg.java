package org.example.generics2.Teste;

class ArrayAlg {
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {

        String[] names = {"Robert", "John", "Daniel"};
        String middle1 = ArrayAlg.<String>getMiddle(names);

        String middle2 = ArrayAlg.getMiddle(names);

        double middle3 = ArrayAlg.<Double>getMiddle(4.9, 1900.0, 0.0);

    }

    public static <T extends Comparable> T min(T[] a) {
        if ((a == null) || (a.length == 0)) {
            return null;
        }

        T smallest = a[0];

        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }

        return smallest;
    }

}
