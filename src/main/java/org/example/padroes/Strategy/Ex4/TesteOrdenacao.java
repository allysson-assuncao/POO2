package org.example.padroes.Strategy.Ex4;

import java.util.Arrays;

public class TesteOrdenacao {
    public static void main(String[] args) {
        Integer[] vetor = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Vetor original: " + Arrays.toString(vetor));

        // Usando BubbleSort
        ContextoOrdenacao<Integer> contexto = new ContextoOrdenacao<>((Sort<Integer>) new BubbleSort<>());
        contexto.ordenarAscendente(vetor);
        System.out.println("Bubble Asc:     " + Arrays.toString(vetor));

        // Trocando a estratégia para SelectionSort
        contexto.setEstrategia(new SelectionSort<>());
        contexto.ordenarDescendente(vetor);
        System.out.println("Selection Desc: " + Arrays.toString(vetor));

        // Trocando para InsertionSort
        contexto.setEstrategia(new InsertionSort<>());
        contexto.ordenarAscendente(vetor);
        System.out.println("Insertion Asc:  " + Arrays.toString(vetor));
    }
}
