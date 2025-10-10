package org.example.generics3.Ex6;

import java.util.HashMap;
import java.util.Map;

public class ImpressorDeMapa {

    // Método genérico para imprimir os pares chave-valor de qualquer Map
    public static <K, V> void imprimirMapa(Map<K, V> mapa) {
        if (mapa == null || mapa.isEmpty()) {
            System.out.println("O mapa está vazio ou é nulo.");
            return;
        }

        System.out.println("--- Conteúdo do Mapa ---");
        for (Map.Entry<K, V> entry : mapa.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        // Mapa de Integer para String
        Map<Integer, String> mapaAlunos = new HashMap<>();
        mapaAlunos.put(101, "Robert");
        mapaAlunos.put(202, "John");
        mapaAlunos.put(303, "Daniel");
        imprimirMapa(mapaAlunos);

        // Mapa de String para Double
        Map<String, Double> mapaProdutos = new HashMap<>();
        mapaProdutos.put("Laptop", 4500.00);
        mapaProdutos.put("Mouse", 150.50);
        mapaProdutos.put("Teclado", 299.99);
        imprimirMapa(mapaProdutos);
    }
}

// Saída:
/*
--- Conteúdo do Mapa ---
Chave: 101, Valor: Robert
Chave: 202, Valor: John
Chave: 303, Valor: Daniel
-------------------------
--- Conteúdo do Mapa ---
Chave: Laptop, Valor: 4500.0
Chave: Mouse, Valor: 150.5
Chave: Teclado, Valor: 299.99
-------------------------
*/
