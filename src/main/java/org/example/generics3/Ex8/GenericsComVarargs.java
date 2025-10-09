package org.example.generics3.Ex8;

public class GenericsComVarargs {

    /**
     * Método genérico que aceita um número variável de argumentos (varargs).
     */
    public static <T> void imprimirElementos(T... elementos) {
        System.out.print("Tipo dos elementos: " + elementos.getClass().getSimpleName());
        System.out.print(" | Elementos recebidos: ");
        if (elementos.length == 0) {
            System.out.println("[Nenhum]");
            return;
        }
        for (T elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Chamadas de Teste ---");

        // Chamada com Strings
        imprimirElementos("Olá", "Mundo", "Generics");

        // Chamada com Integers
        imprimirElementos(10, 20, 30, 40, 50);

        // Chamada com Doubles
        imprimirElementos(3.14, 1.618, 2.71);

        // Chamada sem argumentos
        imprimirElementos();
    }
}

// Saída:
/*

*/
