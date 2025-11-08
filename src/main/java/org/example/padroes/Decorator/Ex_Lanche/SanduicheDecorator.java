package org.example.padroes.Decorator.Ex_Lanche;

// Classe Decorator abstrata
public abstract class SanduicheDecorator implements Sanduiche {

    // Referência ao objeto "envolvido"
    protected Sanduiche sanduicheWrappee;

    // Construtor que recebe o objeto a ser decorado
    public SanduicheDecorator(Sanduiche sanduiche) {
        this.sanduicheWrappee = sanduiche;
    }

    // Delega a chamada para o objeto "envolvido"
    @Override
    public String getDescricao() {
        return sanduicheWrappee.getDescricao();
    }

    // Delega a chamada para o objeto "envolvido"
    @Override
    public double getPreco() {
        return sanduicheWrappee.getPreco();
    }
}
