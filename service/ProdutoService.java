package service;

import enums.CategoriaProduto;
import model.Mercado;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Mercado mercado, String nome, double preco, int estoque, CategoriaProduto categoria) {

        Produto produto = new Produto(nome, preco, estoque, categoria);
        produto.setMercado(mercado);

        mercado.adicionarProduto(produto);
        produtos.add(produto);
    }

    public void listar(Mercado mercado) {
        for (Produto p : mercado.getProdutos()) {
            System.out.println(p);
        }
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }
}
