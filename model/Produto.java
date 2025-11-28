package model;

import enums.CategoriaProduto;
import model.interfaces.IProduto;

public class Produto implements IProduto {

    private String nome;
    private double preco;
    private int estoque;
    private CategoriaProduto categoria;
    private Mercado mercado;

    public Produto(String nome, double preco, int estoque, CategoriaProduto categoria) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    @Override
    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    @Override
    public int getEstoque() { return estoque; }

    @Override
    public CategoriaProduto getCategoria() { return categoria; }

    public void reduzirEstoque(int qtd) { estoque -= qtd; }

    @Override
    public String toString() {
        return "Produto: " + nome +
                " | Preço: " + preco +
                " | Estoque: " + estoque +
                " | Categoria: " + categoria;
    }
}
