package org.example.nested_classes.Ex2;

import java.util.Vector;

public class Pedido {

    private String id;
    private Vector<Item> items;

    public Pedido() {
        this.items = new Vector<Item>();
    }

    public Pedido(String id) {
        this.id = id;
        this.items = new Vector<Item>();
    }

    public Vector<Item> getItems() {
        return items;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    class Item {

        private String nome;
        private int quantidade;

        public Item(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "nome='" + nome + '\'' +
                    ", quantidade=" + quantidade +
                    '}';
        }
    }

}
