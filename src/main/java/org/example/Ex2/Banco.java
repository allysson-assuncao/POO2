package org.example.Ex2;

public class Banco {
    private final ContaBancaria[] contas;

    public Banco(ContaBancaria[] contas) {
        this.contas = contas != null ? contas : new ContaBancaria[0];
    }

    private ContaBancaria buscarConta(int numero) throws CNEException {
        for (ContaBancaria c : contas) {
            if (c != null && c.getNumeroConta() == numero) {
                return c;
            }
        }
        throw new CNEException("Conta nao existente: " + numero);
    }

    public void transferencia(int contaDe, int contaPara, double valor) throws CNEException, SIException {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de transferência inválido");
        }
        ContaBancaria origem = buscarConta(contaDe);
        ContaBancaria destino = buscarConta(contaPara);
        origem.debita(valor);
        destino.credita(valor);
    }

    public void balanco() {
        double totalDepositadoDisponivel = 0.0;
        double totalChequeEspecialUsado = 0.0;

        System.out.println("=== Contas ===");
        for (ContaBancaria c : contas) {
            if (c == null) continue;
            System.out.println(c);
            double saldo = c.getSaldo();
            if (saldo >= 0) {
                totalDepositadoDisponivel += saldo;
            } else {
                totalChequeEspecialUsado += -saldo;
            }
        }
        System.out.println("=== Relatório ===");
        System.out.printf(java.util.Locale.US, "Total depositado e disponível: %.2f%n", totalDepositadoDisponivel);
        System.out.printf(java.util.Locale.US, "Total usado de cheque especial (saldos negativos): %.2f%n", totalChequeEspecialUsado);
    }
}
