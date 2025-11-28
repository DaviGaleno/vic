package model;

import model.interfaces.IVenda;

public class Venda implements IVenda {

    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;
    private double totalVenda;
    private Cliente cliente;

    public Venda(String nomeProduto, int quantidade, double precoUnitario, Cliente cliente) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.totalVenda = quantidade * precoUnitario;
        this.cliente = cliente;
    }

    @Override
    public String getNomeProduto() { return nomeProduto; }

    @Override
    public int getQuantidade() { return quantidade; }

    @Override
    public double getPrecoUnitario() { return precoUnitario; }

    @Override
    public double getTotalVenda() { return totalVenda; }

    @Override
    public Cliente getCliente() { return cliente; }
}
