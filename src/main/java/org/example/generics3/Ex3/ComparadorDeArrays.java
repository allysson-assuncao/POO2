package org.example.generics3.Ex3;

public class ComparadorDeArrays {

    // Método genérico que verifica se dois arrays têm os mesmos elementos na mesma ordem
    public static <T> boolean saoIguais(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
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
        String[] strs3 = {"java", "Generics"};

        System.out.println("strs1 e strs2 são iguais? " + saoIguais(strs1, strs2));

        System.out.println("\n--- Casos de Teste para 'false' ---");
        System.out.println("nums1 e nums3 são iguais? " + saoIguais(nums1, nums3));
        System.out.println("nums1 e nums4 são iguais? " + saoIguais(nums1, nums4));
        System.out.println("strs1 e strs3 são iguais? " + saoIguais(strs1, strs3));
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
