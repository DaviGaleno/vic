package service;

import model.Mercado;
import model.Produto;
import repository.ProdutoRepositorio;

public class ProdutoService {

    private ProdutoRepositorio repo = new ProdutoRepositorio();

    public void cadastrar(Mercado mercado, String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        mercado.adicionarProduto(produto);
        repo.salvar(produto);
        System.out.println("Produto cadastrado no mercado: " + mercado.getNome());
    }

    public void listar() {
        for (Produto p : repo.listar()) {
            System.out.println(p);
        }
    }
}


