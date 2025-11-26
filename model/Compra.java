package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private Cliente cliente;
    private List<ItemCompra> itens = new ArrayList<>();
    private double total;

    public Compra(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemCompra item) {
        itens.add(item);
        total += item.getSubtotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }
}
