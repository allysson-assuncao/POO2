package org.example.generics.Ex4;

public class ArrayAlg<T extends Comparable<? super T>> {
    private final Pair<T>[] data;

    public ArrayAlg(Pair<T>[] data) {
        this.data = data;
    }

    public Pair<T> getMin() {
        if (data == null || data.length == 0) return null;
        Pair<T> min = null;
        for (Pair<T> p : data) {
            if (p == null) continue;
            if (min == null || p.compareTo(min) < 0) {
                min = p;
            }
        }
        return min;
    }

    public Pair<T> getMax() {
        if (data == null || data.length == 0) return null;
        Pair<T> max = null;
        for (Pair<T> p : data) {
            if (p == null) continue;
            if (max == null || p.compareTo(max) > 0) {
                max = p;
            }
        }
        return max;
    }
}
