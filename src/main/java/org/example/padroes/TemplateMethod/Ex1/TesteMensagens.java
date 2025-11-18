package org.example.padroes.TemplateMethod.Ex1;

public class TesteMensagens {

    public static void main(String[] args) {
        System.out.println("--- Teste Manhã ---");
        GeradorMensagem msgManha = new MensagemManha();
        System.out.println(msgManha.gerarMensagem("Ana", "12345"));

        System.out.println("\n--- Teste Tarde ---");
        GeradorMensagem msgTarde = new MensagemTarde();
        System.out.println(msgTarde.gerarMensagem("Bruno", "67890"));

        System.out.println("\n--- Teste Noite ---");
        GeradorMensagem msgNoite = new MensagemNoite();
        System.out.println(msgNoite.gerarMensagem("Carla", "11223"));
    }

}
