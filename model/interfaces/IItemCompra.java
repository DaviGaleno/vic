package model.interfaces;

import model.Produto;

public interface IItemCompra {
    Produto getProduto();
    int getQuantidade();
    double getSubtotal();
}
