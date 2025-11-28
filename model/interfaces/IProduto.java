package model.interfaces;

import enums.CategoriaProduto;
import model.Mercado;

public interface IProduto {
    String getNome();
    double getPreco();
    int getEstoque();
    CategoriaProduto getCategoria();
    Mercado getMercado();
}
