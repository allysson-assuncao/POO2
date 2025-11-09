package org.example.padroes.Observer.Ex_BingoAuto;

import java.util.Set;

public class BingAuto {

    public static void main(String[] args) {
        // 1. Cria o Subject da observação
        Sorteador sorteador = new Sorteador();

        // 2. Cria os Observers (Cartelas)
        // Elas se registram no Sorteador automaticamente pelo construtor
        Cartela cartela1 = new Cartela("Cartela A", sorteador, Set.of(5, 10, 15, 20, 25));
        Cartela cartela2 = new Cartela("Cartela B", sorteador, Set.of(1, 2, 3, 4, 5));
        Cartela cartela3 = new Cartela("Cartela C", sorteador, Set.of(7, 14, 21, 28, 35));

        // 3. Prepara as Threads
        Thread tSorteador = new Thread(sorteador);
        Thread tCartela1 = new Thread(cartela1);
        Thread tCartela2 = new Thread(cartela2);
        Thread tCartela3 = new Thread(cartela3);

        // 4. Inicia as Cartelas primeiro
        // Elas vão iniciar e imediatamente chamar sorteador.wait()
        tCartela1.start();
        tCartela2.start();
        tCartela3.start();

        try {
            // Pequena pausa para garantir que as cartelas esperem o sorteio (wait)
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        // 5. Inicia o Subject (Sorteador)
        // Ele começará a sortear e a notificar as cartelas para verificar a marcação
        tSorteador.start();
    }
}
