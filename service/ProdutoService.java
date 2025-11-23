package service;

import model.Mercado;
import model.Produto;

import java.util.List;

public class ProdutoService {

    public void cadastrar(Mercado mercado, String nome, double preco, int estoque) {
        Produto produto = new Produto(nome, preco, estoque);
        mercado.adicionarProduto(produto);
    }

    public void listar(Mercado mercado) {
        List<Produto> produtos = mercado.getProdutos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n=== PRODUTOS DO MERCADO ===");
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: R$ " + p.getPreco());
            System.out.println("Estoque: " + p.getEstoque());
            System.out.println("-----------------------------");
        }
    }
}
