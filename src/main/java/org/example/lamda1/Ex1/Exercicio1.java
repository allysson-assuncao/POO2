package org.example.lamda1.Ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercicio1 {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList(
            "prefixo", "presunto", "prever", "java", "predicado", "lambda"
        ));

        System.out.println("Lista original: " + lista);

        // 1. Cria a expressão lambda (Predicate) que verifica se a string começa com "pre"
        Predicate<String> comecaComPre = s -> s.startsWith("pre");

        // Usa o predicado original e o método 'negate()' para remover quem não começa com "pre"
        lista.removeIf(comecaComPre.negate());

        System.out.println("Lista filtrada (removeIf): " + lista);
    }
}
