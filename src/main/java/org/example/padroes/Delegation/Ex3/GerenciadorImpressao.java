package org.example.padroes.Delegation.Ex3;

/**
 * O Delegador (Delegador).
 * Ele implementa a interface que o Cliente usa,
 * mas DELEGA a chamada para o Delegado.
 */
public class GerenciadorImpressao implements ServicoImpressao {

    // O Delegador "tem um" Delegado
    private final ImpressoraReal delegado;

    public GerenciadorImpressao(ImpressoraReal delegado) {
        this.delegado = delegado;
    }

    /**
     * O Cliente chama este método.
     * O Delegador não faz o trabalho, ele apenas repassa (delega)
     * para o método correspondente do Delegado.
     */
    @Override
    public void imprimir(String documento) {
        System.out.println("[Delegador] Recebendo solicitação para: " + documento);
        // Delegação da chamada
        delegado.realizarImpressao(documento);
        System.out.println("[Delegador] Serviço de impressão concluído.");
    }
}
