package org.example.generics3.Ex8;

public class GenericsComVarargs {

    // Método genérico que imprime um número variável de argumentos (varargs)
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

        imprimirElementos("Olá", "Mundo", "Generics");

        imprimirElementos(10, 20, 30, 40, 50);

        imprimirElementos(3.14, 1.618, 2.71);

        imprimirElementos();
    }
}

// Saída:
/*
Tipo dos elementos: String[] | Elementos recebidos: Olá Mundo Generics
Tipo dos elementos: Integer[] | Elementos recebidos: 10 20 30 40 50
Tipo dos elementos: Double[] | Elementos recebidos: 3.14 1.618 2.71
Tipo dos elementos: Object[] | Elementos recebidos: [Nenhum]
*/
