package org.example.padroes.Strategy.Ex5;

import java.util.Arrays;
import java.util.Collections;

/**
 * Interface funcional para ordenação.
 * Ela tem apenas UM método abstrato: 'ascending'.
 * O método 'descending' é 'default', ou seja, já tem implementação.
 */
@FunctionalInterface
public interface SortFuncional<T extends Comparable<T>> {

    // 1. Único método abstrato
    void ascending(T[] v);

    // 2. Implementação default
    default void descending(T[] v) {
        // A implementação default reusa a 'ascending' e depois inverte o vetor
        ascending(v);
        Collections.reverse(Arrays.asList(v));
    }
}
