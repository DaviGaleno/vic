package model;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.ICompra;

public class Compra implements ICompra {

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

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public List<ItemCompra> getItens() {
        return itens;
    }

    @Override
    public double getTotal() {
        return total;
    }
}
