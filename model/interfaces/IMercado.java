package model.interfaces;

import model.Produto;

public interface IMercado {
    String getCnpj();
    Produto buscarProdutoPorNome(String nome);
}
