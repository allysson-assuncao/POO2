package org.example.padroes.Strategy.Ex2;

public class TesteRestaurante {

    public static void main(String[] args) {
        ChefPrincipal chef = new ChefPrincipal();

        // Definindo os sub-chefs (estratégias) iniciais
        chef.setEstrategiaGrelhados(new SubChefGrelhados());
        chef.setEstrategiaSaladas(new SubChefSaladas());
        chef.setEstrategiaSobremesas(new SubChefSobremesas());

        System.out.println("--- Pedido 1 (Completo) ---");
        chef.prepararPedido("Picanha", "Salada Caesar", "Pudim");

        System.out.println("\n--- Pedido 2 (Só Salada e Sobremesa) ---");
        chef.prepararPedido(null, "Salada de Frutas", "Sorvete");

        // Trocando os papéis  (Ex: Sub-chef de saladas agora faz grelhados)
        System.out.println("\n--- Trocando papéis ---");
        PreparacaoStrategy cozinheiroVersatil = new SubChefSaladas();
        // Agora o cozinheiro de saladas vai fazer grelhados
        chef.setEstrategiaGrelhados(cozinheiroVersatil);

        System.out.println("--- Pedido 3 (Após troca) ---");
        chef.prepararPedido("Frango Grelhado", null, null);
    }

}
