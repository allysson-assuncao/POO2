package org.example.enums.Ex3;

public enum Atividade {PROJETO(40), TRABALHO(20), PROVA_PRATICA(30), PROVA_TEORICA(10);

    private double peso;

    Atividade(double peso) {
        this.peso = peso;
    }

    public void validar(double nota){
        if(nota < 0){
            throw new IllegalArgumentException("A nota não pode ser negativa!");
        }
        if(nota > 10){
            throw new IllegalArgumentException("A nota não pode ser maior que 10!");
        }
    }

    public static String calcularMediaPonderada(double valorAvaliacao, Atividade... atividades){
        if (atividades == null || atividades.length == 0) {
            throw new IllegalArgumentException("É necessário informar ao menos uma atividade.");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < atividades.length; i++) {
            Atividade a = atividades[i];
            double contribuicao = valorAvaliacao * (a.peso / 100.0);
            sb.append(a.name()).append(": ").append(String.format("%.2f", contribuicao));
            if (i < atividades.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
