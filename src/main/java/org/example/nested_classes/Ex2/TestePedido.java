package org.example.nested_classes.Ex2;

public class TestePedido {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("1");

        Pedido.Item hamburguer = pedido.new Item("x-tudo", 2);
        Pedido.Item pizza = pedido.new Item("pizza moda", 1);

        pedido.addItems(hamburguer);
        pedido.addItems(pizza);

        for(Pedido.Item i : pedido.getItems()){
            System.out.println(i.toString());
        }

    }

}
