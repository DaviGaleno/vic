package service;

import model.Mercado;
import model.Produto;
import enums.CategoriaProduto;

public class ProdutoService {

    public void cadastrar(Mercado mercado, String nome, double preco, int estoque, CategoriaProduto categoria) {
        Produto produto = new Produto(nome, preco, estoque, categoria);
        mercado.adicionarProduto(produto);
    }

    public void listar(Mercado mercado) {
        if (mercado.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : mercado.getProdutos()) {
            System.out.println(p);
        }
    }
}
