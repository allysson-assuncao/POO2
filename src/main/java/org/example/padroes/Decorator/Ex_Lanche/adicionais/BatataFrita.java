package org.example.padroes.Decorator.Ex_Lanche.adicionais;

import org.example.padroes.Decorator.Ex_Lanche.Sanduiche;
import org.example.padroes.Decorator.Ex_Lanche.SanduicheDecorator;

public class BatataFrita extends SanduicheDecorator {

    public BatataFrita(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", acompanhado de Batata Frita";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 6.50;
    }
}
