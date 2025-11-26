package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class CompraService {

    private List<Compra> compras = new ArrayList<>();

    public void registrarCompra(Compra compra) {
        compras.add(compra);
    }

    public List<Compra> listarCompras() {
        return compras;
    }
}
