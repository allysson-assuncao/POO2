package org.example.generics.Ex2;

import java.util.ArrayList;

public class TestaEmpregado {

    public static void main(String[] args) {

        ArrayList<Employee> array = new ArrayList<>();

        array.add(new Employee.Manager());

    }

}
