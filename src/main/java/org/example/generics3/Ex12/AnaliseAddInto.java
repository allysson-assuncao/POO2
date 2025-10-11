package org.example.generics3.Ex12;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AnaliseAddInto {

    public Collection<?> addInto(Object toAdd) {
        List<Object> list = new LinkedList<>();
        list.add(toAdd);
        return list;
    }

    public static void main(String[] args) {
        AnaliseAddInto exemplo = new AnaliseAddInto();

        Collection<?> colecao = exemplo.addInto("Um texto qualquer");
        System.out.println("Conteúdo da coleção: " + colecao);

        // Erro de compilação ao tentar adicionar: The method add(capture#1-of ?) in the type Collection<capture#1-of ?> is not applicable for the arguments (String)
        // colecao.add("Outro texto");

        Object elemento = colecao.iterator().next();
        System.out.println("Tipo do elemento recuperado: " + elemento.getClass().getName());

        try {
            // Cast correto
            String textoRecuperado = (String) elemento;
            System.out.println("Cast para String bem-sucedido: " + textoRecuperado.toUpperCase());

            // Cast incorreto
            System.out.println("\nTentando fazer um cast incorreto para Integer...");
            Integer numeroRecuperado = (Integer) elemento; // lança ClassCastException
        } catch (ClassCastException e) {
            System.err.println("ERRO: Ocorreu uma ClassCastException! Não foi possível converter String para Integer.");
        }
    }
}

// Saída:
/*
Conteúdo da coleção: [Um texto qualquer]
Tipo do elemento recuperado: java.lang.String
Cast para String bem-sucedido: UM TEXTO QUALQUER

Tentando fazer um cast incorreto para Integer...
ERRO: Ocorreu uma ClassCastException! Não foi possível converter String para Integer.
*/
