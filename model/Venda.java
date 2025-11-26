package model;

public class Venda {

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

    public String getNomeProduto() { return nomeProduto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
    public double getTotalVenda() { return totalVenda; }
    public Cliente getCliente() { return cliente; }
}
