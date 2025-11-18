package org.example.padroes.Strategy.Ex4;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void ascending(T[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].compareTo(v[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            T temp = v[min_idx];
            v[min_idx] = v[i];
            v[i] = temp;
        }
    }

    @Override
    public void descending(T[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].compareTo(v[max_idx]) > 0) {
                    max_idx = j;
                }
            }
            T temp = v[max_idx];
            v[max_idx] = v[i];
            v[i] = temp;
        }
    }
}
