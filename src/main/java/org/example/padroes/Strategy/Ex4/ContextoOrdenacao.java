package org.example.padroes.Strategy.Ex4;

/**
 * O Contexto que utiliza uma estratégia de ordenação.
 */
public class ContextoOrdenacao<T extends Comparable<T>> {

    private Sort<T> estrategia;

    public ContextoOrdenacao(Sort<T> estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(Sort<T> estrategia) {
        this.estrategia = estrategia;
    }

    public void ordenarAscendente(T[] v) {
        estrategia.ascending(v);
    }

    public void ordenarDescendente(T[] v) {
        estrategia.descending(v);
    }
}
