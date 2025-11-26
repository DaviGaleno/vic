package model;

import enums.CategoriaProduto;

public class Produto {

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

    public Mercado getMercado() { return mercado; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public CategoriaProduto getCategoria() { return categoria; }
    public void reduzirEstoque(int qtd) { this.estoque -= qtd; }

    @Override
    public String toString() {
        return "Produto: " + nome +
                " | Preço: " + preco +
                " | Estoque: " + estoque +
                " | Categoria: " + categoria;
    }
}
