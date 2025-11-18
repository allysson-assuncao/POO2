package org.example.padroes.Delegation.Ex3;

/**
 * O Delegado (Delegado).
 * Este objeto faz o trabalho real, mas não é
 * diretamente exposto ao cliente.
 */
public class ImpressoraReal {

    // Este é o método que executa a impressão de fato
    public void realizarImpressao(String conteudo) {
        System.out.println("[ImpressoraReal] Imprimindo... << " + conteudo + " >>");
    }
}
