package org.example.padroes.Delegation.Ex3;

/**
 * O Cliente.
 * Ele só conhece o Delegador (através da interface ServicoImpressao)
 * e não sabe da existência da ImpressoraReal (Delegado).
 */
public class ClienteImpressao {
    public static void main(String[] args) {
        // 1. O Delegado é criado
        ImpressoraReal impressora = new ImpressoraReal();

        // 2. O Delegador é criado, contendo o Delegado
        ServicoImpressao servico = new GerenciadorImpressao(impressora);

        // 3. O Cliente faz a chamada ao Delegador
        System.out.println("Cliente: Solicitando impressão do 'Relatório.pdf'");
        servico.imprimir("Relatório.pdf");
    }
}
