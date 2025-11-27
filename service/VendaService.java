package service;

import model.Mercado;
import model.Venda;

public class VendaService {

    public void registrarVenda(Mercado mercado, Venda venda) {
        mercado.registrarVenda(venda); // agora salva direto no mercado
    }

    public double calcularTotalFaturado(Mercado mercado) {
        return mercado.getVendas().stream()
                .mapToDouble(Venda::getTotalVenda)
                .sum();
    }
}
