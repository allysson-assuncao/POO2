package org.example.generics3.Ex9;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Classes de exemplo
class Animal { public String toString() { return "Animal"; } }
class Gato extends Animal { public String toString() { return "Gato"; } }

public class TesteWildcardVsGenerico {

    // Versão 1: Método Genérico
    public <T extends Animal> void printCollectionTyped(Collection<T> animals) {
        System.out.print("Typed: ");
        animals.forEach(animal -> System.out.print(animal + " "));
        System.out.println();
    }

    // Versão 2: Wildcard
    public void printCollectionWildcard(Collection<? extends Animal> animals) {
        System.out.print("Wildcard: ");
        animals.forEach(animal -> System.out.print(animal + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        TesteWildcardVsGenerico teste = new TesteWildcardVsGenerico();
        List<Gato> listaDeGatos = Arrays.asList(new Gato(), new Gato());

        System.out.println("Passando uma List<Gato> para ambos os métodos:");
        teste.printCollectionTyped(listaDeGatos);
        teste.printCollectionWildcard(listaDeGatos);
    }
}
