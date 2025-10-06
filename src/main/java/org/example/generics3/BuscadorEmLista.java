package org.example.generics3;

import java.util.Arrays;
import java.util.List;

public class BuscadorEmLista {

    /**
     * Versão 1: Método genérico com tipo <T>
     * Garante que o elemento a ser procurado é do mesmo tipo da lista.
     */
    public static <T> int encontrarIndice(List<T> lista, T elemento) {
        return lista.indexOf(elemento);
    }

    /**
     * Versão 2: Método com wildcard irrestrito <?>
     * Aceita uma lista de qualquer tipo e um objeto qualquer para a busca.
     * [cite: 659]
     */
    public static int encontrarIndiceCoringa(List<?> lista, Object elemento) {
        return lista.indexOf(elemento);
    }

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Robert", "John", "Daniel", "John");

        System.out.println("--- Usando o método genérico <T> ---");
        String nomeParaBuscar = "Daniel";
        int indice1 = encontrarIndice(nomes, nomeParaBuscar);
        System.out.printf("O índice de '%s' é: %d\n", nomeParaBuscar, indice1); // 2

        String nomeInexistente = "Michael";
        int indice2 = encontrarIndice(nomes, nomeInexistente);
        System.out.printf("O índice de '%s' é: %d\n", nomeInexistente, indice2); // -1

        System.out.println("\n--- Usando o método com wildcard <?> ---");
        int indice3 = encontrarIndiceCoringa(nomes, "John");
        System.out.printf("O índice de 'John' é: %d\n", indice3); // 1 (primeira ocorrência)

        int indice4 = encontrarIndiceCoringa(nomes, 123); // Buscando um tipo diferente
        System.out.printf("O índice do inteiro 123 é: %d\n", indice4); // -1
    }
}

// Saída:

/*
--- Usando o método genérico <T> ---
O índice de 'Daniel' é: 2
O índice de 'Michael' é: -1

--- Usando o método com wildcard <?> ---
O índice de 'John' é: 1
O índice do inteiro 123 é: -1
*/
