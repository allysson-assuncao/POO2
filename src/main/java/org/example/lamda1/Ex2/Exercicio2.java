package org.example.lamda1.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exercicio2 {

    public static void main(String[] args) {
        List<String> listaComNulos = new ArrayList<>(Arrays.asList(
                "java", null, "lambda", "predicate", null, "ifmg"
        ));

        System.out.println("Lista original: " + listaComNulos);

        // Método 'isNull' de Objects para remover apenas os nulos
        listaComNulos.removeIf(Objects::isNull);

        System.out.println("Lista sem nulos: " + listaComNulos);
    }

}
