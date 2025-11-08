package org.example.padroes.Decorator.Ex_Lanche.molhos;

import org.example.padroes.Decorator.Ex_Lanche.Sanduiche;
import org.example.padroes.Decorator.Ex_Lanche.SanduicheDecorator;

// Decorador Concreto
public class MolhoMostarda extends SanduicheDecorator {

    public MolhoMostarda(Sanduiche sanduiche) {
        // Passa o sanduíche a ser decorado para o construtor pai
        super(sanduiche);
    }

    // Adiciona o novo comportamento/descrição
    @Override
    public String getDescricao() {
        // Chama o método do wrappee e adiciona o seu comportamento específico
        return super.getDescricao() + ", com Molho Barbecue";
    }

    @Override
    public double getPreco() {
        // Chama o método do wrappee e adiciona o seu custo adicional
        return super.getPreco() + 2.50;
    }

}
