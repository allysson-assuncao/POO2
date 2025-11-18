package org.example.padroes.Strategy.Ex2;

/**
 * O Contexto (Chef Principal) que delega as tarefas.
 * Ele mantém referências às estratégias (sub-chefs) e pode
 * trocá-las dinamicamente.
 */
public class ChefPrincipal {

    // O chef pode ter vários "papéis" para delegar
    private PreparacaoStrategy estrategiaGrelhados;
    private PreparacaoStrategy estrategiaSaladas;
    private PreparacaoStrategy estrategiaSobremesas;

    // O chef "controla os papéis" definindo quem faz o quê
    public void setEstrategiaGrelhados(PreparacaoStrategy estrategiaGrelhados) {
        this.estrategiaGrelhados = estrategiaGrelhados;
    }

    public void setEstrategiaSaladas(PreparacaoStrategy estrategiaSaladas) {
        this.estrategiaSaladas = estrategiaSaladas;
    }

    public void setEstrategiaSobremesas(PreparacaoStrategy estrategiaSobremesas) {
        this.estrategiaSobremesas = estrategiaSobremesas;
    }

    // Método que delega as tarefas
    public void prepararPedido(String grelhado, String salada, String sobremesa) {
        if (grelhado != null && estrategiaGrelhados != null) {
            estrategiaGrelhados.preparar(grelhado);
        }
        if (salada != null && estrategiaSaladas != null) {
            estrategiaSaladas.preparar(salada);
        }
        if (sobremesa != null && estrategiaSobremesas != null) {
            estrategiaSobremesas.preparar(sobremesa);
        }
    }
}
