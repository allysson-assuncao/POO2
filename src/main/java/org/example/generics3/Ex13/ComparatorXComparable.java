package org.example.generics3.Ex13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorXComparable {

    public static class Car implements Comparable<Car> {

        private double valor;

        public Car(double valor) {
            this.valor = valor;
        }

        @Override
        public int compareTo(Car o) {
            return this.valor > o.valor ? 1 : (this.valor < o.valor ? -1 : 0);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "valor=" + valor +
                    '}';
        }
    }

    private class Comparador implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1 instanceof Car ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(5000));
        cars.add(new Car(2000));
        cars.add(new Car(1000));
        cars.add(new Car(3000));
        Collections.sort(cars);

        for (Car car : cars) {
            System.out.println(car.toString());
        }

    }

}

// Saída:
/*

*/
