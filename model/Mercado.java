package model;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private String nomeFantasia;
    private String cnpj;
    private String senha;

    private List<Produto> produtos = new ArrayList<>();

    public Mercado(String nomeFantasia, String cnpj, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getNome() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Mercado: " + nomeFantasia + " | CNPJ: " + cnpj;
    }
}
