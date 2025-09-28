package org.example.generics2.Exercicios;

public class ArrayUtils {

    // Método selectionSort genérico para ordenar os elementos de um vetor (desde que T implemente Comparable)
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int smallestIndex = i;

            // Encontra o menor elemento
            for (int index = i + 1; index < data.length; index++) {
                if (data[index].compareTo(data[smallestIndex]) < 0) {
                    smallestIndex = index;
                }
            }

            // Troca com o atual
            swap(data, i, smallestIndex);
        }
    }

    // Método auxiliar para a troca
    private static <T> void swap(T[] data, int first, int second) {
        T temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    // Método genérico para exibir os elementos de um vetor em um intervalo específico
    public static <T> void printArray(T[] inputArray, int lowSubscript, int rightSubscript) throws InvalidSubscriptException {

        // Validação dos subscritos
        if (lowSubscript < 0 || rightSubscript > inputArray.length || lowSubscript > rightSubscript) {
            throw new InvalidSubscriptException(
                    String.format("Intervalo [%d, %d) fora dos limites para o tamanho do vetor (%d).",
                            lowSubscript, rightSubscript, inputArray.length)
            );
        }

        System.out.print("Exibindo elementos do vetor: ");
        for (int i = lowSubscript; i < rightSubscript; i++) {
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();
    }

    public static void printArray(String[] inputArray, int lowSubscript, int rightSubscript) throws InvalidSubscriptException {

        if (lowSubscript < 0 || rightSubscript > inputArray.length || lowSubscript > rightSubscript) {
            throw new InvalidSubscriptException(
                    String.format("Intervalo [%d, %d) fora dos limites para o tamanho do vetor (%d).",
                            lowSubscript, rightSubscript, inputArray.length)
            );
        }

        System.out.print("Exibindo vetor de Strings (formato tabular):\n");
        for (int i = lowSubscript; i < rightSubscript; i++) {
            System.out.printf("%s\t", inputArray[i]);
        }
        System.out.println();
    }
}
