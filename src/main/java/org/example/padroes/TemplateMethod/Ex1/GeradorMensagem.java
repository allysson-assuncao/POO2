package org.example.padroes.TemplateMethod.Ex1;

/**
 * Define o esqueleto (template) para gerar a mensagem.
 * O método 'gerarMensagem' é o Template Method.
 */
public abstract class GeradorMensagem {

    public final String gerarMensagem(String nome, String numPedido) {
        StringBuilder sb = new StringBuilder();

        // Partes fixas da estrutura
        sb.append("Olá ").append(nome).append(",\n");

        // Parte variável 1: Cumprimento
        sb.append(getCumprimento()).append("\n");

        // Parte fixa
        sb.append("Segue o situação de seu pedido número ").append(numPedido).append(":\n");

        // Parte variável 2: Fechamento
        sb.append(getFechamento()).append(",\n");

        // Parte fixa
        sb.append("Dados do E-commerce");

        return sb.toString();
    }

    // Métodos abstratos que devem ser implementados pelas subclasses para fornecer o conteúdo variável
    protected abstract String getCumprimento();
    protected abstract String getFechamento();
}
