package org.example.lamda1.Ex3;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;

public class Exercicio3 {

    public static void main(String[] args) {

        // Consumer: takes an object, returns nothing (void accept(T t))
        Consumer<String> printer = s -> System.out.println("Message: " + s);
        System.out.println("\n=== Consumer Examples ===");
        printer.accept("Hello Lambda!");
        printer.accept("This is fun!");
        // Saída Esperada:
        // Message: Hello Lambda!
        // Message: This is fun!

        // Supplier: takes no arguments, returns an object (T get())
        Supplier<String> greeting = () -> "Welcome to Java!";
        System.out.println("\n=== Supplier Examples ===");
        System.out.println(greeting.get());
        System.out.println(greeting.get());
        // Saída Esperada:
        // Welcome to Java!
        // Welcome to Java!

        // Predicate: takes an object, returns boolean (boolean test(T t))
        Predicate<String> hasThreeChars = s -> s.length() == 3;
        System.out.println("\n=== Predicate Examples ===");
        System.out.println("'cat' has 3 chars: " + hasThreeChars.test("cat"));
        System.out.println("'dog' has 3 chars: " + hasThreeChars.test("dog"));
        System.out.println("'elephant' has 3 chars: " + hasThreeChars.test("elephant"));
        // Saída Esperada:
        // 'cat' has 3 chars: true
        // 'dog' has 3 chars: true
        // 'elephant' has 3 chars: false

        // Function: takes one object, returns another (R apply(T t))
        Function<String, Integer> getLength = s -> s.length();
        System.out.println("\n=== Function Examples ===");
        System.out.println("Length of 'Java': " + getLength.apply("Java"));
        System.out.println("Length of 'Programming': " + getLength.apply("Programming"));
        // Saída Esperada:
        // Length of 'Java': 4
        // Length of 'Programming': 11

        // Try creating your own lambdas!
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("\n=== Your Turn ===");
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));
        // Saída Esperada:
        // Is 4 even? true
        // Is 7 even? false

        // Todas as saídas conferem
    }
}
