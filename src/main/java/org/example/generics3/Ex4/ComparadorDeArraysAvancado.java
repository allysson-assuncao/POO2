package org.example.generics3.Ex4;

public class ComparadorDeArraysAvancado {

    // Método genérico que compara dois arrays de forma mais avançada
    public static <T> int compararArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }

        boolean mesmosObjetos = true;
        for (int i = 0; i < array1.length; i++) {
            // Verifica a igualdade de estado, se for diferente, retorna -1.
            if (!array1[i].equals(array2[i])) {
                return -1;
            }
            if (array1[i] != array2[i]) {
                mesmosObjetos = false;
            }
        }

        // Se todos os elementos forem iguais, retorna 0, caso contrário -1
        return mesmosObjetos ? 0 : 1;
    }

    public static void main(String[] args) {
        String[] s1 = {"gato", "cachorro"};
        String[] s2 = s1;
        String[] s3 = {"gato", "cachorro"};
        String[] s4 = {new String("gato"), new String("cachorro")};
        String[] s5 = {"gato", "peixe"};

        System.out.println("Comparando s1 e s2 (mesma referência de array): " + compararArrays(s1, s2));
        System.out.println("Comparando s1 e s3 (mesmo conteúdo, objetos literais): " + compararArrays(s1, s3));
        System.out.println("Comparando s1 e s4 (mesmo conteúdo, objetos novos): " + compararArrays(s1, s4));
        System.out.println("Comparando s1 e s5 (conteúdo diferente): " + compararArrays(s1, s5));
    }
}

// Saída:
/*
Comparando s1 e s2 (mesma referência de array): 0
Comparando s1 e s3 (mesmo conteúdo, objetos literais): 0
Comparando s1 e s4 (mesmo conteúdo, objetos novos): 1
Comparando s1 e s5 (conteúdo diferente): -1
*/
