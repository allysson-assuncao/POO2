package org.example.padroes.TemplateMethod.Ex1;

/**
 * Implementação concreta para o período da Tarde.
 */
public class MensagemTarde extends GeradorMensagem {

    @Override
    protected String getCumprimento() {
        return "Boa tarde";
    }

    @Override
    protected String getFechamento() {
        return "Tenha uma ótima tarde";
    }
}
