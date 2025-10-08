package org.example.generics3.Ex2;

import java.util.Arrays;
import java.util.List;

public class SomaPrimos {

    private static boolean isPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método genérico que recebe números quaiquer (coringa) e retorna a soma dos que são inteiros positivos e primos.
    public static long somarPrimosPositivos(List<? extends Number> lista) {
        long soma = 0;
        for (Number n : lista) {
            if (n instanceof Integer) {
                int valorInt = n.intValue();
                if (valorInt > 0 && isPrimo(valorInt)) {
                    soma += valorInt;
                }
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        List<Integer> listaDeInteiros = Arrays.asList(2, 3, 4, 5, 6, 7, 11, 13, -17, 0);
        List<Number> listaDeNumeros = Arrays.asList(17, 19.5, 20, 23, 29.0, 31);

        System.out.println("Lista de Inteiros: " + listaDeInteiros);
        long soma1 = somarPrimosPositivos(listaDeInteiros);
        // Soma esperada: 2 + 3 + 5 + 7 + 11 + 13 = 41
        System.out.println("Soma dos primos positivos: " + soma1);

        System.out.println("\nLista de Números: " + listaDeNumeros);
        long soma2 = somarPrimosPositivos(listaDeNumeros);
        // Soma esperada: 17 + 23 + 31 = 71 (ignora 19.5 e 29.0, pois não são Integer)
        System.out.println("Soma dos primos positivos: " + soma2);
    }
}

// Saída :
/*
Lista de Inteiros: [2, 3, 4, 5, 6, 7, 11, 13, -17, 0]
Soma dos primos positivos: 41

Lista de Números: [17, 19.5, 20, 23, 29.0, 31]
Soma dos primos positivos: 71
*/
