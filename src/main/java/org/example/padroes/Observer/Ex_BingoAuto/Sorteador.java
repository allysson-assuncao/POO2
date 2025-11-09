package org.example.padroes.Observer.Ex_BingoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Sorteador implements Runnable {

    // 1. Lista as cartelas
    private final List<Cartela> cartelas;
    private final List<Integer> pedras; // O recipiente com as pedras

    private int pedraSorteada;
    private boolean novoNumeroDisponivel = false;
    private boolean jogoEmAndamento = true;
    private Cartela vencedora = null;

    // Ferramenta de sincronização: garante que o Sorteador espere
    // todas as cartelas terminarem de verificar o número sorteado na rodada.
    private CountDownLatch latchDaRodada;

    public Sorteador() {
        this.cartelas = new ArrayList<>();
        this.pedras = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            pedras.add(i);
        }
        Collections.shuffle(pedras); // Embaralha as pedras
    }

    // Método para Observers se registrarem
    public synchronized void addCartela(Cartela cartela) {
        this.cartelas.add(cartela);
    }

    @Override
    public void run() {
        System.out.println("--- O BINGO VAI COMEÇAR! ---");

        while (jogoEmAndamento && !pedras.isEmpty()) {
            try {
                // Prepara o latch para a contagem de observers
                latchDaRodada = new CountDownLatch(cartelas.size());

                // Bloco sincronizado para alterar o estado e notificar
                synchronized (this) {
                    // Sorteia a pedra
                    this.pedraSorteada = pedras.removeFirst();
                    this.novoNumeroDisponivel = true;
                    System.out.println("\n-------------------------------------");
                    System.out.println("SORTEADOR: *** Pedra " + this.pedraSorteada + " ***");

                    // 2. Notifica todas as Cartelas
                    this.notifyAll(); // Acorda as threads
                }

                // 3. Espera todas as cartelas terminarem
                // O Sorteador só continua quando o latch chegar a 0
                latchDaRodada.await();

                // Reseta a flag para a próxima rodada
                synchronized (this) {
                    this.novoNumeroDisponivel = false;
                }

                // Pausa para simular algo mais real
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n--- FIM DE JOGO ---");
        if(vencedora != null) {
            System.out.println("A VENCEDORA FOI: " + vencedora.getNome());
        } else {
            System.out.println("Não houve vencedor. As pedras acabaram.");
        }
    }

    // --- Métodos de sincronização usados pelas Cartelas ---

    public synchronized void declararVencedor(Cartela cartela) {
        if (this.vencedora == null) {
            this.vencedora = cartela;
            this.jogoEmAndamento = false;
        }
    }

    public void notificarVerificacaoConcluida() {
        latchDaRodada.countDown(); // Cartela avisa: "Terminei de verificar"
    }

    public boolean isJogoEmAndamento() {
        return jogoEmAndamento;
    }

    // Getters sincronizados para as cartelas pegarem o estado
    public synchronized int getPedraSorteada() {
        return pedraSorteada;
    }

    public synchronized boolean isNovoNumeroDisponivel() {
        return novoNumeroDisponivel;
    }
}
