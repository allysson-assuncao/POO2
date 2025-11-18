package org.example.padroes.Strategy.Ex2;

/**
 * A interface Strategy define a operação comum para todos
 * os sub-chefs (algoritmos) suportados.
 */
public interface PreparacaoStrategy {
    void preparar(String item);
}
