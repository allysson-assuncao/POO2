package org.example.generics3.Ex4;

public class ComparadorDeArrays {

    /**
     * Método genérico para verificar se dois arrays têm os mesmos elementos na mesma ordem.
     * [cite: 11]
     */
    public static <T> boolean saoIguais(T[] array1, T[] array2) {
        // 1. Verifica se o tamanho é diferente
        if (array1.length != array2.length) {
            return false;
        }

        // 2. Compara cada elemento
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false; // Retorna falso na primeira diferença encontrada
            }
        }

        // 3. Se o laço terminou, os arrays são iguais
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 2, 3, 4};
        Integer[] nums2 = {1, 2, 3, 4};
        Integer[] nums3 = {1, 2, 5, 4};
        Integer[] nums4 = {1, 2, 3};

        System.out.println("nums1 e nums2 são iguais? " + saoIguais(nums1, nums2)); // true

        String[] strs1 = {"Java", "Generics"};
        String[] strs2 = {"Java", "Generics"};
        String[] strs3 = {"java", "Generics"}; // "java" com 'j' minúsculo

        System.out.println("strs1 e strs2 são iguais? " + saoIguais(strs1, strs2)); // true

        System.out.println("\n--- Casos de Teste para 'false' ---");
        System.out.println("nums1 e nums3 são iguais? " + saoIguais(nums1, nums3)); // false (elemento diferente)
        System.out.println("nums1 e nums4 são iguais? " + saoIguais(nums1, nums4)); // false (tamanho diferente)
        System.out.println("strs1 e strs3 são iguais? " + saoIguais(strs1, strs3)); // false (diferença de maiúscula/minúscula)
    }
}

// Saída:
/*
nums1 e nums2 são iguais? true
strs1 e strs2 são iguais? true

--- Casos de Teste para 'false' ---
nums1 e nums3 são iguais? false
nums1 e nums4 são iguais? false
strs1 e strs3 são iguais? false
*/
