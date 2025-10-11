package org.example.generics3.Ex11;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TesteWildcardInvalido {

    // A assinatura do método abaixo é sintaticamente incorreta
    /*public Collection<?> createNewListAndAdd(? toAdd) { // erro de compilação: Wildcards may only be used as reference parameters
        List<?> list = new LinkedList<>();
        list.add(toAdd); // não se pode adicionar elementos a uma coleção de tipo desconhecido
        return list;
    }*/
}
