package org.example.generics3.Ex5;

import java.util.Arrays;
import java.util.List;

public class BuscadorEmLista {

    // Método genérico com tipo <T>, garante que o elemento procurado é do mesmo tipo da lista
    public static <T> int encontrarIndice(List<T> lista, T elemento) {
        return lista.indexOf(elemento);
    }

    // Método com wildcard irrestrito <?>, aceita a busca de elementos de tipo diferente da lista
    public static int encontrarIndiceCoringa(List<?> lista, Object elemento) {
        return lista.indexOf(elemento);
    }

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Roberto", "João", "Daniel", "João");

        System.out.println("--- Usando o método genérico <T> ---");
        String nomeParaBuscar = "Daniel";
        int indice1 = encontrarIndice(nomes, nomeParaBuscar);
        System.out.printf("O índice de '%s' é: %d\n", nomeParaBuscar, indice1);

        String nomeInexistente = "Maria";
        int indice2 = encontrarIndice(nomes, nomeInexistente);
        System.out.printf("O índice de '%s' é: %d\n", nomeInexistente, indice2);

        System.out.println("\n--- Usando o método com wildcard <?> ---");
        int indice3 = encontrarIndiceCoringa(nomes, "João");
        System.out.printf("O índice de 'João' é: %d\n", indice3);

        int indice4 = encontrarIndiceCoringa(nomes, 123);
        System.out.printf("O índice do inteiro 123 é: %d\n", indice4);
    }
}

// Saída:
/*
--- Usando o método genérico <T> ---
O índice de 'Daniel' é: 2
O índice de 'Maria' é: -1

--- Usando o método com wildcard <?> ---
O índice de 'João' é: 1
O índice do inteiro 123 é: -1
*/
