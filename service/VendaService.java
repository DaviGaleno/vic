package service;

import model.Mercado;
import model.Venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendaService {

    private HashMap<Mercado, List<Venda>> vendasPorMercado = new HashMap<>();

    public void registrarVenda(Mercado mercado, Venda venda) {
        vendasPorMercado.putIfAbsent(mercado, new ArrayList<>());
        vendasPorMercado.get(mercado).add(venda);
    }

    public List<Venda> listarVendas(Mercado mercado) {
        return vendasPorMercado.getOrDefault(mercado, new ArrayList<>());
    }

    public double calcularTotalFaturado(Mercado mercado) {
        return listarVendas(mercado).stream()
                .mapToDouble(Venda::getTotalVenda)
                .sum();
    }
}
