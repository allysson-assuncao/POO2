package org.example.padroes.Strategy.Ex2;

/**
 * Estratégia concreta para saladas.
 */
public class SubChefSaladas implements PreparacaoStrategy {
    @Override
    public void preparar(String item) {
        System.out.println("Sub-chef de saladas: Montando " + item);
    }
}
