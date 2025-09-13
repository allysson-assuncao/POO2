package org.example.exeptions.Ex2;

public class TestaBanco {
    public static void main(String[] args) {
        ContaBancaria[] contas = new ContaBancaria[4];
        contas[0] = new ContaBancaria(1, 1000.0, false, 0.0);   // comum
        contas[1] = new ContaBancaria(2, 500.0, true, 1000.0);  // especial, limite 1000
        contas[2] = new ContaBancaria(3, 200.0, false, 0.0);    // comum
        contas[3] = new ContaBancaria(4, 0.0, true, 500.0);     // especial, limite 500

        Banco banco = new Banco(contas);

        executar(banco, 1, 2, 200.0, 1);
        executar(banco, 2, 3, 800.0, 2);
        executar(banco, 3, 1, 50.0, 3);
        executar(banco, 3, 4, 300.0, 4);
        executar(banco, 2, 4, 300.0, 5);
        executar(banco, 4, 1, 100.0, 6);
        executar(banco, 1, 3, 1200.0, 7); // deve falhar (saldo insuficiente)
        executar(banco, 5, 1, 10.0, 8);   // deve falhar (conta não existente)
        executar(banco, 2, 3, 500.0, 9);
        executar(banco, 4, 2, 800.0, 10); // deve falhar (limite excedido)

        banco.balanco();
    }

    private static void executar(Banco banco, int de, int para, double valor, int idx) {
        try {
            banco.transferencia(de, para, valor);
            System.out.printf(java.util.Locale.US, "Transferencia %d OK: %d -> %d valor %.2f%n", idx, de, para, valor);
        } catch (CNEException | SIException e) {
            System.out.printf("Transferencia %d FALHOU: %s%n", idx, e.getMessage());
        }
    }
}
