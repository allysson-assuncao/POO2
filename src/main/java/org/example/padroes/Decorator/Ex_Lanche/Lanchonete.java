package org.example.padroes.Decorator.Ex_Lanche;

import org.example.padroes.Decorator.Ex_Lanche.acrescimos.QueijoExtra;
import org.example.padroes.Decorator.Ex_Lanche.adicionais.BatataFrita;
import org.example.padroes.Decorator.Ex_Lanche.molhos.MolhoBarbecue;
import org.example.padroes.Decorator.Ex_Lanche.molhos.MolhoMostarda;

public class Lanchonete {

    public static void main(String[] args) {

        System.out.println("--- Pedido 1 (Completo) ---");
        // 1. Começa com o objeto base
        Sanduiche meuSanduiche = new SanduicheBase();

        // 2. Adiciona queijo (envolve o sanduíche base)
        meuSanduiche = new QueijoExtra(meuSanduiche);

        // 3. Adiciona molho (envolve o sanduíche com queijo)
        meuSanduiche = new MolhoBarbecue(meuSanduiche);

        // 4. Adiciona acompanhamento (envolve o sanduíche com queijo e molho)
        meuSanduiche = new MolhoMostarda(meuSanduiche);

        // 5. Adiciona acompanhamento (envolve o sanduíche com queijo e molhos)
        meuSanduiche = new BatataFrita(meuSanduiche);

        System.out.println("Descrição: " + meuSanduiche.getDescricao());
        System.out.println("Preço Total: R$ " + meuSanduiche.getPreco());


        System.out.println("\n--- Pedido 2 (Simples) ---");
        // Outro pedido, criado dinamicamente com outra combinação
        Sanduiche sanduicheSimples = new SanduicheBase();
        sanduicheSimples = new MolhoBarbecue(sanduicheSimples);

        System.out.println("Descrição: " + sanduicheSimples.getDescricao());
        System.out.println("Preço Total: R$ " + sanduicheSimples.getPreco());
    }
}
