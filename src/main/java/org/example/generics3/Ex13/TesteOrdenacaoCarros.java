package org.example.generics3.Ex13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car {
    private String marca;
    private int ano;
    private double valor;

    public Car(String marca, int ano, double valor) {
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    public double getValor() { return valor; }
    public int getAno() { return ano; }

    @Override
    public String toString() {
        return String.format("Carro{marca='%s', ano=%d, valor=R$%.2f}", marca, ano, valor);
    }
}

// Comparable para a ordenação por valor
class CarroOrdenavel extends Car implements Comparable<CarroOrdenavel> {
    public CarroOrdenavel(String marca, int ano, double valor) {
        super(marca, ano, valor);
    }

    @Override
    public int compareTo(CarroOrdenavel outro) {
        return Double.compare(this.getValor(), outro.getValor());
    }
}

// Comparator para ordenação por ano
class ComparadorCarroPorAno implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getAno(), c2.getAno());
    }
}

public class TesteOrdenacaoCarros {
    public static void main(String[] args) {
        System.out.println("--- Ordenando com Comparable (ordem natural por valor) ---");
        List<CarroOrdenavel> listaOrdenavel = new ArrayList<>();
        listaOrdenavel.add(new CarroOrdenavel("Fiat", 2022, 75000.0));
        listaOrdenavel.add(new CarroOrdenavel("Ford", 2020, 95000.0));
        listaOrdenavel.add(new CarroOrdenavel("BYD", 2023, 72000.0));

        System.out.println("Lista antes de ordenar:");
        listaOrdenavel.forEach(System.out::println);

        Collections.sort(listaOrdenavel);

        System.out.println("\nLista depois de ordenar por valor:");
        listaOrdenavel.forEach(System.out::println);

        System.out.println("\n\n--- Ordenando com Comparator (ordem alternativa por ano) ---");
        List<Car> listaCarros = new ArrayList<>();
        listaCarros.add(new Car("Fiat", 2022, 75000.0));
        listaCarros.add(new Car("Ford", 2020, 95000.0));
        listaCarros.add(new Car("BYD", 2023, 72000.0));

        System.out.println("Lista antes de ordenar:");
        listaCarros.forEach(System.out::println);

        listaCarros.sort(new ComparadorCarroPorAno());

        System.out.println("\nLista depois de ordenar por ano:");
        listaCarros.forEach(System.out::println);
    }
}

// Saída

/*
--- Ordenando com Comparable (ordem natural por valor) ---
Lista antes de ordenar:
Carro{marca='Fiat', ano=2022, valor=R$75000,00}
Carro{marca='Ford', ano=2020, valor=R$95000,00}
Carro{marca='BYD', ano=2023, valor=R$72000,00}

Lista depois de ordenar por valor:
Carro{marca='BYD', ano=2023, valor=R$72000,00}
Carro{marca='Fiat', ano=2022, valor=R$75000,00}
Carro{marca='Ford', ano=2020, valor=R$95000,00}


--- Ordenando com Comparator (ordem alternativa por ano) ---
Lista antes de ordenar:
Carro{marca='Fiat', ano=2022, valor=R$75000,00}
Carro{marca='Ford', ano=2020, valor=R$95000,00}
Carro{marca='BYD', ano=2023, valor=R$72000,00}

Lista depois de ordenar por ano:
Carro{marca='Ford', ano=2020, valor=R$95000,00}
Carro{marca='Fiat', ano=2022, valor=R$75000,00}
Carro{marca='BYD', ano=2023, valor=R$72000,00}
*/
