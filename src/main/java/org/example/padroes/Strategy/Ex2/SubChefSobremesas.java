package org.example.padroes.Strategy.Ex2;

/**
 * Estratégia concreta para sobremesas.
 */
public class SubChefSobremesas implements PreparacaoStrategy {
    @Override
    public void preparar(String item) {
        System.out.println("Sub-chef de sobremesas: Finalizando " + item);
    }
}
