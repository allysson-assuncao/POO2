package org.example.enums.Ex3;

public enum Atividade {PROJETO(40), TRABALHO(20), PROVA_PRATICA(30), PROVA_TEORICA(10);

    private double peso;

    Atividade(double peso) {
        this.peso = peso;
    }

    private void validar(double nota){
        if(nota < 0){
            throw new IllegalArgumentException("A nota não pode ser negativa!");
        }
        if(nota > 10){
            throw new IllegalArgumentException("A nota não pode ser maior que 10!");
        }
    }

    private void calcularMediaPonderada(double valorAvaliacao, Atividade... atividades){

    }

}
