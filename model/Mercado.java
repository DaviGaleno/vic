package model;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private String nome;
    private String cnpj;
    private List<Produto> produtos = new ArrayList<>();

    public Mercado(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Mercado: " + nome + " | CNPJ: " + cnpj;
    }
}
