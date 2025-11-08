package org.example.padroes.Decorator.Ex_Lanche.acrescimos;

import org.example.padroes.Decorator.Ex_Lanche.Sanduiche;
import org.example.padroes.Decorator.Ex_Lanche.SanduicheDecorator;

public class QueijoExtra extends SanduicheDecorator {

    public QueijoExtra(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", com Queijo Extra";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 3.00;
    }
}
