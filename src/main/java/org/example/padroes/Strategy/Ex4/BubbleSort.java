package org.example.padroes.Strategy.Ex4;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void ascending(T[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (v[j].compareTo(v[j + 1]) > 0) {
                    // troca
                    T temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void descending(T[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (v[j].compareTo(v[j + 1]) < 0) {
                    // troca
                    T temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }
}
