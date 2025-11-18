package org.example.padroes.Strategy.Ex2;

/**
 * Estratégia concreta para grelhados.
 */
public class SubChefGrelhados implements PreparacaoStrategy {
    @Override
    public void preparar(String item) {
        System.out.println("Sub-chef de grelhaados: Preparando " + item);
    }
}
