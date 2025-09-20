package org.example.generics.Ex2;

import java.util.ArrayList;

public class TestaEmpregado {

    public static void main(String[] args) {

        ArrayList<Employee> array = new ArrayList<>();

        array.add(new Employee());

        array.add(new Manager());

        for (Employee e : array) {
            System.out.println(e.getClass().getSimpleName());
        }

        // ArrayList<Manager> não é subtipo de ArrayList<Employee>.
        // O código abaixo NÃO compila:
        /*ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Employee> employees = managers;*/
        // "incompatible types: java.util.ArrayList<org.example.generics.Ex2.Manager> cannot be converted to java.util.ArrayList<org.example.generics.Ex2.Employee>"

    }

}
