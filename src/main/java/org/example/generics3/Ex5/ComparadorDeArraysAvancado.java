package org.example.generics3.Ex5;

public class ComparadorDeArraysAvancado {

    /**
     * Método genérico que compara dois arrays e retorna:
     * 0: se possuem os mesmos objetos na mesma ordem (igualdade de referência).
     * +1: se possuem objetos com estados idênticos na mesma ordem (igualdade de valor).
     * -1: se são diferentes em tamanho ou conteúdo.
     */
    public static <T> int compararArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }

        boolean mesmosObjetos = true;
        for (int i = 0; i < array1.length; i++) {
            // Primeiro, verifica a igualdade de estado. Se for diferente, retorna -1.
            if (!array1[i].equals(array2[i])) {
                return -1;
            }
            // Se a igualdade de referência falhar para qualquer elemento,
            // eles não podem ser os mesmos objetos.
            if (array1[i] != array2[i]) {
                mesmosObjetos = false;
            }
        }

        // Se o laço completou, todos os elementos são pelo menos .equals().
        // Agora, decidimos entre 0 e +1.
        return mesmosObjetos ? 0 : 1;
    }

    public static void main(String[] args) {
        String[] s1 = {"gato", "cachorro"};
        String[] s2 = s1; // s2 aponta para o mesmo objeto array que s1
        String[] s3 = {"gato", "cachorro"}; // Conteúdo igual, mas objetos diferentes
        String[] s4 = {new String("gato"), new String("cachorro")}; // Objetos explicitamente novos
        String[] s5 = {"gato", "peixe"};

        System.out.println("Comparando s1 e s2 (mesma referência de array): " + compararArrays(s1, s2)); // Retorna 0
        System.out.println("Comparando s1 e s3 (mesmo conteúdo, objetos literais): " + compararArrays(s1, s3)); // Retorna 0 (literais são otimizados)
        System.out.println("Comparando s1 e s4 (mesmo conteúdo, objetos novos): " + compararArrays(s1, s4)); // Retorna 1
        System.out.println("Comparando s1 e s5 (conteúdo diferente): " + compararArrays(s1, s5)); // Retorna -1
    }
}

// Saída:
/*
Comparando s1 e s2 (mesma referência de array): 0
Comparando s1 e s3 (mesmo conteúdo, objetos literais): 0
Comparando s1 e s4 (mesmo conteúdo, objetos novos): 1
Comparando s1 e s5 (conteúdo diferente): -1
*/
