package org.example.generics.Ex4;

public class Pair<T extends Comparable<? super T>> implements Comparable<Pair<T>> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair<T> other) {
        if (other == null) return 1; // non-null > null
        int c = compareNullable(this.first, other.first);
        if (c != 0) return c;
        return compareNullable(this.second, other.second);
    }

    private int compareNullable(T a, T b) {
        if (a == b) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
