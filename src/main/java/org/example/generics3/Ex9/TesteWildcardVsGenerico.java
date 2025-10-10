package org.example.generics3.Ex9;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Classes peo exemplo
class Animal { public String toString() { return "Animal"; } }
class Gato extends Animal { public String toString() { return "Gato"; } }

public class TesteWildcardVsGenerico {

    public <T extends Animal> void printCollectionTyped(Collection<T> animals) {
        System.out.print("Genérico: ");
        animals.forEach(animal -> System.out.print(animal + " "));
        System.out.println();
    }

    public void printCollectionWildcard(Collection<? extends Animal> animals) {
        System.out.print("Coringa com limite superior: ");
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

// Saída:
/*
Passando uma List<Gato> para ambos os métodos:
Genérico: Gato Gato
Coringa com limite superior: Gato Gato
*/
