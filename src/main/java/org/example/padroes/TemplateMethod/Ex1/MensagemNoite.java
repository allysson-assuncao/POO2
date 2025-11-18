package org.example.padroes.TemplateMethod.Ex1;

/**
 * Implementação concreta para o período da Noite.
 */
public class MensagemNoite extends GeradorMensagem {

    @Override
    protected String getCumprimento() {
        return "Boa noite";
    }

    @Override
    protected String getFechamento() {
        return "Tenha uma ótima noite";
    }
}
