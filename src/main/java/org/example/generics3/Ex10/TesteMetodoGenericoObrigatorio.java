package org.example.generics3.Ex10;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

// Classes de exemplo da questão anterior
class Animal { public String toString() { return "Animal"; } }
class Cachorro extends Animal { public String toString() { return "Cachorro"; } }

public class TesteMetodoGenericoObrigatorio {

    public <T extends Animal> Collection<T> createNewListAndAdd(T toAdd) {
        List<T> list = new LinkedList<>();
        list.add(toAdd);
        return list;
    }

    public static void main(String[] args) {
        TesteMetodoGenericoObrigatorio teste = new TesteMetodoGenericoObrigatorio();

        Cachorro meuCachorro = new Cachorro();

        // Chamada válida: o compilador infere que T é Cachorro
        Collection<Cachorro> colecaoDeCachorros = teste.createNewListAndAdd(meuCachorro);

        System.out.println("Tipo da coleção retornada: " + colecaoDeCachorros.getClass().getName());
        System.out.println("Conteúdo: " + colecaoDeCachorros);

        // O tipo do retorno é estaticamente verificado
        Animal meuAnimal = new Animal();
        Collection<Animal> colecaoDeAnimais = teste.createNewListAndAdd(meuAnimal);
        System.out.println("Conteúdo: " + colecaoDeAnimais);

        // Chamada inválida (causa erro de compilação)
        // Collection<Gato> colecaoDeGatos = teste.createNewListAndAdd(meuCachorro);
    }
}

// Saída:
/*
Tipo da coleção retornada: java.util.LinkedList
Conteúdo: [Cachorro]
Conteúdo: [Animal]
*/
