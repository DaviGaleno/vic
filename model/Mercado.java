package model;

import model.interfaces.IMercado;

import java.util.ArrayList;
import java.util.List;

public class Mercado extends Cadastro implements IMercado {

    private String cnpj;
    private List<Produto> produtos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public Mercado(String nomeFantasia, String cnpj, String senha) {
        super(nomeFantasia, senha);
        this.cnpj = cnpj;
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

    @Override
    public Produto buscarProdutoPorNome(String nome) {
        return null;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    @Override
    public String toString() {
        return "Mercado: " + nome + " | CNPJ: " + cnpj;
    }
}
