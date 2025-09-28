package org.example.generics2.Exercicios;

public class InvalidSubscriptException extends IllegalArgumentException {

    public InvalidSubscriptException() {
        super("Erro: Subscrito inválido. Verifique os limites do intervalo.");
    }

    public InvalidSubscriptException(String message) {
        super(message);
    }
}
