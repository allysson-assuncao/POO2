package org.example.generics.Ex3;

public class TestaPar {

    static class Animal implements Comparable<Animal> {
        private final int rank;
        private final String name;
        Animal(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Animal o) {
            if (o == null) return 1;
            int c = Integer.compare(this.rank, o.rank);
            if (c != 0) return c;
            if (this.name == null && o.name == null) return 0;
            if (this.name == null) return -1;
            if (o.name == null) return 1;
            return this.name.compareTo(o.name);
        }
        @Override
        public String toString() { return name + "#" + rank; }
    }

    static class Dog extends Animal {
        Dog(String name, int rank) { super(name, rank); }
    }

    public static void main(String[] args) {
        // 1) Tipos idênticos (String)
        Pair<String> ps1 = new Pair<>("Ana", "Bruno");
        Pair<String> ps2 = new Pair<>("Ana", "Carlos");
        System.out.println("String vs String => " + ps1 + " ? " + ps2 + " = " + ps1.compareTo(ps2));

        // 2) Tipos compatíveis (herança) usando Animal e Dog
        Pair<Animal> pa1 = new Pair<>(new Animal("A", 1), new Dog("B", 2));
        Pair<Animal> pa2 = new Pair<>(new Dog("C", 1), new Animal("D", 3));
        System.out.println("Animal/Dog vs Dog/Animal => " + pa1 + " ? " + pa2 + " = " + pa1.compareTo(pa2));

        // 3) Tipos distintos (demonstra erro de compilação)
        Pair<String> pStr = new Pair<>("a", "b");
        Pair<Integer> pInt = new Pair<>(1, 2);
        // int r = pStr.compareTo(pInt); // incompatible types: org.example.generics.Ex3.Pair<java.lang.Integer> cannot be converted to org.example.generics.Ex3.Pair<java.lang.String>

        // 4) Comparação com nulls
        Pair<String> pn = new Pair<>(null, "x");
        Pair<String> pm = new Pair<>(null, "y");
        System.out.println("Null-safe => " + pn + " ? " + pm + " = " + pn.compareTo(pm));
    }
}
