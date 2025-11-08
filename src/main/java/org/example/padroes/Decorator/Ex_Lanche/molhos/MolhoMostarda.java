package org.example.padroes.Decorator.Ex_Lanche.molhos;

import org.example.padroes.Decorator.Ex_Lanche.Sanduiche;
import org.example.padroes.Decorator.Ex_Lanche.SanduicheDecorator;

public class MolhoMostarda extends SanduicheDecorator {

    public MolhoMostarda(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", com Molho de Mostarda";
    }

    @Override
    public double getPreco() {
        // Chama o método do wrappee e adiciona o seu custo adicional
        return super.getPreco() + 2.00;
    }

}
