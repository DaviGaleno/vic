package model.interfaces;

import java.util.List;
import model.Cliente;
import model.ItemCompra;

public interface ICompra {
    Cliente getCliente();
    List<ItemCompra> getItens();
    double getTotal();
}
