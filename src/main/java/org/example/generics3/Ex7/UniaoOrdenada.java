package org.example.generics3.Ex7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniaoOrdenada {

    // Método genérico de ordenação (Selection Sort). O tipo T deve ser comparável
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Método genérico para ordenar e unir dois arrays em uma lista ordenada
    public static <T extends Comparable<T>> List<T> unirArraysOrdenados(T[] array1, T[] array2) {
        selectionSort(array1);
        selectionSort(array2);

        List<T> listaUnida = new ArrayList<>();
        int i = 0, j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) <= 0) {
                listaUnida.add(array1[i]);
                i++;
            } else {
                listaUnida.add(array2[j]);
                j++;
            }
        }

        while (i < array1.length) {
            listaUnida.add(array1[i]);
            i++;
        }
        while (j < array2.length) {
            listaUnida.add(array2[j]);
            j++;
        }

        return listaUnida;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {5, 1, 9, 3};
        Integer[] nums2 = {8, 2, 7, 4, 6};

        System.out.println("Array 1 original: " + Arrays.toString(nums1));
        System.out.println("Array 2 original: " + Arrays.toString(nums2));

        List<Integer> resultado = unirArraysOrdenados(nums1, nums2);

        System.out.println("Lista unida e ordenada: " + resultado);
    }
}

// Saída:
/*
Array 1 original: [5, 1, 9, 3]
Array 2 original: [8, 2, 7, 4, 6]
Lista unida e ordenada: [1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
