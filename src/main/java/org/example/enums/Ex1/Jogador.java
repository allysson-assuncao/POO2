package org.example.enums.Ex1;

public class Jogador {

    private static int adicionarPontos(TipoDePonto... pontos){
        int pontuacaoTotal = 0;
        for(TipoDePonto p : pontos){
            pontuacaoTotal += p.getPontuacao();
        }
        return pontuacaoTotal;
    }

    public static void main(String[] args) {
        System.out.println("Pontuação total: " + adicionarPontos(TipoDePonto.values()));
    }

}
