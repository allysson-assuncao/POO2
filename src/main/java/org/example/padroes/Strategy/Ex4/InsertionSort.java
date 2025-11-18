package org.example.padroes.Strategy.Ex4;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void ascending(T[] v) {
        int n = v.length;
        for (int i = 1; i < n; ++i) {
            T key = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].compareTo(key) > 0) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = key;
        }
    }

    @Override
    public void descending(T[] v) {
        int n = v.length;
        for (int i = 1; i < n; ++i) {
            T key = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].compareTo(key) < 0) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = key;
        }
    }
}
