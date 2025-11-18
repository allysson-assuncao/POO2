package org.example.padroes.Strategy.Ex5;

import java.util.Arrays;

public class TesteLambdaSort {
    public static void main(String[] args) {

        // Exemplo 1: Implementando Bubble Sort com Lambda
        SortFuncional<Integer> bubbleSortLambda = (v) -> {
            System.out.println("Executando BubbleSort (Lambda)");
            int n = v.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (v[j].compareTo(v[j + 1]) > 0) {
                        Integer temp = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = temp;
                    }
                }
            }
        };

        // Exemplo 2: Implementando Selection Sort com Lambda
        SortFuncional<Integer> selectionSortLambda = (v) -> {
            System.out.println("Executando SelectionSort (Lambda)");
            int n = v.length;
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (v[j].compareTo(v[min_idx]) < 0) {
                        min_idx = j;
                    }
                }
                Integer temp = v[min_idx];
                v[min_idx] = v[i];
                v[i] = temp;
            }
        };

        // --- Testando ---
        Integer[] vetor = {5, 1, 4, 2, 8};
        System.out.println("Vetor original: " + Arrays.toString(vetor));

        // Testando a implementação Lambda (Bubble)
        bubbleSortLambda.ascending(vetor);
        System.out.println("Lambda Asc (Bubble): " + Arrays.toString(vetor));

        // Testando o método DEFAULT 'descending'
        // (ele vai chamar o 'ascending' do bubble e inverter)
        bubbleSortLambda.descending(vetor);
        System.out.println("Lambda Desc (Default): " + Arrays.toString(vetor));

        System.out.println("---");

        // Testando a implementação Lambda (Selection)
        Integer[] vetor2 = {7, 3, 9, 0};
        System.out.println("Vetor original: " + Arrays.toString(vetor2));
        selectionSortLambda.ascending(vetor2);
        System.out.println("Lambda Asc (Selection): " + Arrays.toString(vetor2));
    }
}
