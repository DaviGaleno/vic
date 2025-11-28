package model.interfaces;

import model.Cliente;

public interface IVenda {
    String getNomeProduto();
    int getQuantidade();
    double getPrecoUnitario();
    double getTotalVenda();
    Cliente getCliente();
}
