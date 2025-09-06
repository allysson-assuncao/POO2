package org.example.Ex2;

public class ContaBancaria {
    private final int numeroConta;
    private double saldo;
    private final boolean clienteEspecial;
    private final double limite;

    public ContaBancaria(int numeroConta, double saldoInicial, boolean clienteEspecial, double limite) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.clienteEspecial = clienteEspecial;
        this.limite = clienteEspecial ? Math.max(0.0, limite) : 0.0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isClienteEspecial() {
        return clienteEspecial;
    }

    public double getLimite() {
        return limite;
    }

    public void debita(double v) throws SIException {
        if (v < 0) {
            throw new IllegalArgumentException("Valor de débito inválido");
        }
        double disponivel = saldo + (clienteEspecial ? limite : 0.0);
        if (v > disponivel) {
            throw new SIException("Saldo insuficiente para debitar " + v + " da conta " + numeroConta);
        }
        saldo -= v;
    }

    public void credita(double v) {
        if (v < 0) {
            throw new IllegalArgumentException("Valor de crédito inválido");
        }
        saldo += v;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numeroConta +
                ", saldo=" + String.format(java.util.Locale.US, "%.2f", saldo) +
                ", especial=" + clienteEspecial +
                ", limite=" + String.format(java.util.Locale.US, "%.2f", limite) +
                '}';
    }
}
