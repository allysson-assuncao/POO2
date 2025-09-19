package org.example.enums.Ex1;

public enum TipoDePonto {VITORIA(100), ABATE(20), ITEM_ESPECIAL(5);

    private int pontuacao;

    TipoDePonto(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

}
