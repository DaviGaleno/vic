package model;

import model.interfaces.IItemCompra;

public class ItemCompra implements IItemCompra {

    private Produto produto;
    private int quantidade;

    public ItemCompra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public Produto getProduto() {
        return produto;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
