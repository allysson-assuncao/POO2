package org.example.padroes.TemplateMethod.Ex1;

/**
 * Implementação concreta para o período da Manhã.
 */
public class MensagemManha extends GeradorMensagem {

    @Override
    protected String getCumprimento() {
        return "Bom dia";
    }

    @Override
    protected String getFechamento() {
        return "Tenha um ótimo dia";
    }
}
