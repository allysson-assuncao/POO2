package org.example.lamda1.Ex4;

import java.util.Arrays;
import java.util.List;

public class Exercicio4 {

    /**
     * 1. Sim, o exemplo funciona perfeitamente.
     *
     * 2. Por quê? O método 'forEach' (adicionado à interface 'List'),
     * espera um argumento do tipo da interface funcional 'java.util.function.Consumer'.
     *
     * 3. Interface Funcional: Consumer<T>
     * - O 'Consumer' é uma interface funcional que define
     * um único método abstrato: 'void accept(T t)'.
     * - Ele "consome" um argumento (tipo T) e não retorna nada (void).
     *
     * 4. A Expressão Lambda: fruit -> System.out.println(fruit)
     * - Esta expressão lambda é uma implementação válida da interface Consumer<String>.
     * - 'fruit' é o argumento do tipo String (inferido da lista 'fruits').
     * - 'System.out.println(fruit)' é a ação a ser executada, que
     * retorna 'void'.
     */
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("maçã", "banana", "abacaxi", "pera");

        fruits.forEach(fruit -> System.out.println(fruit));

        System.out.println("\n--- Usando Method Reference ---");
        fruits.forEach(System.out::println);
    }
}
