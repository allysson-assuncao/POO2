package org.example.generics2.Exercicios;

import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        Integer[] intArray = { 5, 1, 9, 3, 7 };
        Double[] doubleArray = { 8.8, 2.2, 7.7, 3.3, 6.6 };
        String[] stringArray = { "Zebra", "Leao", "Gato", "Baleia", "Elefante" };

        System.out.println("--- Testando Exercício 1: selectionSort Genérico ---");
        ArrayUtils.selectionSort(intArray);
        System.out.println("Vetor de Inteiros ordenado: " + Arrays.toString(intArray));

        ArrayUtils.selectionSort(stringArray);
        System.out.println("Vetor de Strings ordenado: " + Arrays.toString(stringArray));
        System.out.println("\n----------------------------------------------------\n");

        System.out.println("--- Testando Exercício 2: printArray Genérico ---");
        try {
            ArrayUtils.printArray(intArray, 1, 4);

            ArrayUtils.printArray(doubleArray, 0, doubleArray.length);
        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("\n----------------------------------------------------\n");


        System.out.println("--- Testando Exercício 3: Sobrecarga para String[] ---");

        try {
            ArrayUtils.printArray(stringArray, 0, 5);
        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("\n----------------------------------------------------\n");


        System.out.println("--- Testando a Exceção ---");
        try {
            System.out.println("Tentando imprimir com intervalo inválido [2, 6]...");
            ArrayUtils.printArray(intArray, 2, 6);
        } catch (InvalidSubscriptException e) {
            System.err.println("Exceção capturada com sucesso: " + e.getMessage());
        }
    }
}
