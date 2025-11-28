package org.example.Testes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Testes {

    public static void main(String[] args) {

        Comparator<String> lenghtAndThenLexico = Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER);

        List<String> l = Arrays.asList("seg", "ter", "qua", "qui", "");

    }

}
