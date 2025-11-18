package org.example.padroes.Strategy.Ex4;

/**
 * Interface Strategy para algoritmos de ordenação.
 * Usamos 'T extends Comparable<T>' para garantir que os
 * objetos no vetor possam ser comparados.
 */
public interface Sort<T extends Comparable<T>> {

    void ascending(T[] v); //ordem ascendente [cite: 17]

    void descending(T[] v); //ordem descentente [cite: 17]
}
