package org.example.enums.Ex3;

public class TestaAtividade {

    public static void main(String[] args) {
        double notaProjeto = 8.5;
        double notaTrabalho = 7.0;
        double notaPratica = 9.0;
        double notaTeorica = 6.5;

        // Validação das notas
        Atividade.PROJETO.validar(notaProjeto);
        Atividade.TRABALHO.validar(notaTrabalho);
        Atividade.PROVA_PRATICA.validar(notaPratica);
        Atividade.PROVA_TEORICA.validar(notaTeorica);

        // Exemplo de cálculo de média ponderada para um valor de avaliação (por exemplo, média final 8.0)
        String resultado = Atividade.calcularMediaPonderada(8.0,
                Atividade.PROJETO, Atividade.TRABALHO, Atividade.PROVA_PRATICA, Atividade.PROVA_TEORICA);

        System.out.println("Contribuições por atividade para média 8.0:");
        System.out.println(resultado);
    }

}
