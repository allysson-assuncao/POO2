package org.example.padroes.Observer.Ex_BingoAuto;

import java.util.HashSet;
import java.util.Set;

public class Cartela implements Runnable {

    private final String nome;
    private final Sorteador sorteador;
    private final Set<Integer> meusNumeros;
    private final Set<Integer> numerosMarcados;

    public Cartela(String nome, Sorteador sorteador, Set<Integer> numeros) {
        this.nome = nome;
        this.sorteador = sorteador;
        this.meusNumeros = numeros;
        this.numerosMarcados = new HashSet<>();

        // Registro da Cartela (Observer) no Sorteador (Subject)
        this.sorteador.addCartela(this);
    }

    public String getNome() { return nome; }

    @Override
    public void run() {
        // A thread da cartela fica ativa enquanto o jogo durar
        while (sorteador.isJogoEmAndamento()) {
            try {
                // A cartela usa o 'sorteador' como monitor de lock
                synchronized (sorteador) {
                    // 1. Espera pela notificação
                    // (Enquanto não houver número, a thread dorme)
                    while (!sorteador.isNovoNumeroDisponivel() && sorteador.isJogoEmAndamento()) {
                        sorteador.wait();
                    }
                }

                // Jogo pode ter acabado enquanto esperava
                if (!sorteador.isJogoEmAndamento()) break;

                // 2. Após serem notificadas as cartelas processam a verificação da pedra tirada
                int pedra = sorteador.getPedraSorteada();

                // 3. Reage à notificação
                verificarNumero(pedra);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 4. Avisa ao Sorteador que terminou
                // Se o latch for nulo, o jogo pode estar acabando
                if (sorteador.isNovoNumeroDisponivel()) {
                     sorteador.notificarVerificacaoConcluida();
                }
            }
        }
    }

    private void verificarNumero(int pedra) {
        if (meusNumeros.contains(pedra)) {
            numerosMarcados.add(pedra);
            System.out.println("  -> " + nome + ": MARCOU " + pedra + "!");

            // 4. Verificação de BINGO
            if (numerosMarcados.size() == meusNumeros.size()) {
                System.out.println("!!! BINGO !!! " + nome + " VENCEU!");
                sorteador.declararVencedor(this);
            }
        }
    }
}
