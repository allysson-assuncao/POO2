package org.example.padroes.Decorator.Ex_Lanche;

// Componente Concreto
public class SanduicheBase implements Sanduiche {

    @Override
    public String getDescricao() {
        return "Sanduíche base (Pão e Carne)";
    }

    @Override
    public double getPreco() {
        return 12.00; // Preço inicial
    }
}
