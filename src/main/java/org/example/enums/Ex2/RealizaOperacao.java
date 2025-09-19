package org.example.enums.Ex2;

public class RealizaOperacao {

    public static double calcular(Operacao operacao, double... numeros) {
        if (operacao == null) {
            throw new IllegalArgumentException("Operacao nao pode ser nula");
        }
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("Informe ao menos um numero");
        }
        if (numeros.length == 1) {
            return numeros[0];
        }
        return calcularRec(operacao, numeros[0], numeros, 1);
    }

    private static double calcularRec(Operacao operacao, double resultado, double[] numeros, int index) {
        if (index >= numeros.length) {
            return resultado;
        }
        double novoResultado = operacao.executar(resultado, numeros[index]);
        return calcularRec(operacao, novoResultado, numeros, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(calcular(Operacao.SOMA, 1, 2, 3, 4));
        System.out.println(calcular(Operacao.SUBTRACAO, 10, 2, 3));
        System.out.println(calcular(Operacao.MULTIPLICACAO, 2, 3, 4));
        System.out.println(calcular(Operacao.DIVISAO, 100, 2, 5));
    }
}
