package org.example.lamda1.Ex5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercicio5 {

    // a) Helper method that uses Predicate
    public List<String> filterWords(List<String> words, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (predicate.test(word)) {
                result.add(word);
            }
        }
        return result;
    }

    // b) Helper method that uses Consumer
    public void processWords(List<String> words, Consumer<String> processor) {
        for (String word : words) {
            processor.accept(word);
        }
    }

    // c) Helper method for numbers
    public List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                result.add(number);
            }
        }
        return result;
    }

    // Método main para demonstrar a "utilidade" dos métodos acima
    public static void main(String[] args) {
        Exercicio5 exercicio = new Exercicio5();

        // --- Demonstração do item (a) filterWords ---
        System.out.println("--- Teste filterWords (a) ---");
        List<String> palavras = Arrays.asList("lambda", "java", "filtro", "stream", "ifmg");
        // Lambda: queremos palavras com mais de 4 letras
        Predicate<String> maisDe4Letras = s -> s.length() > 4;
        List<String> palavrasFiltradas = exercicio.filterWords(palavras, maisDe4Letras);
        System.out.println("Palavras originais: " + palavras);
        System.out.println("Palavras com > 4 letras: " + palavrasFiltradas);
        System.out.println();

        // --- Demonstração do item (b) processWords ---
        System.out.println("--- Teste processWords (b) ---");
        // Lambda: queremos imprimir em maiúsculas
        Consumer<String> imprimirMaiusculo = s -> System.out.println(s.toUpperCase());
        System.out.println("Processando palavras para maiúsculas:");
        exercicio.processWords(palavras, imprimirMaiusculo);
        System.out.println();

        // --- Demonstração do item (c) filterNumbers ---
        System.out.println("--- Teste filterNumbers (c) ---");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Lambda: queremos apenas números pares
        Predicate<Integer> ehPar = n -> n % 2 == 0;
        List<Integer> numerosPares = exercicio.filterNumbers(numeros, ehPar);
        System.out.println("Números originais: " + numeros);
        System.out.println("Números pares: " + numerosPares);
    }
}
