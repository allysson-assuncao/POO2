package org.example.nested_classes.Ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteOrdenacao {

    public static void main(String[] args) {
        List<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(new Produto("Notebook Gamer", 7500.00, 10));
        listaDeProdutos.add(new Produto("Mouse sem fio", 150.50, 50));
        listaDeProdutos.add(new Produto("Teclado Mecânico", 450.00, 30));
        listaDeProdutos.add(new Produto("Monitor 4K", 2300.00, 15));

        System.out.println("--- Lista de Produtos Desordenada ---");
        for (Produto p : listaDeProdutos) {
            System.out.println(p);
        }

        Collections.sort(listaDeProdutos, new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                // Ordem: preço, do menor para o maior;
                return Double.compare(p1.getPreco(), p2.getPreco());
            }
        });

        System.out.println("\n--- Lista de Produtos Ordenada por Preço (Menor para Maior) ---");
        for (Produto p : listaDeProdutos) {
            System.out.println(p);
        }
    }
}
