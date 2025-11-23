package repository;

import model.Mercado;
import java.util.ArrayList;
import java.util.List;

public class MercadoRepositorio {

    private List<Mercado> mercados = new ArrayList<>();

    public void salvar(Mercado mercado) {
        mercados.add(mercado);
    }

    public Mercado buscarPorCnpj(String cnpj) {
        for (Mercado m : mercados) {
            if (m.getCnpj().equals(cnpj)) return m;
        }
        return null;
    }

    public List<Mercado> getTodos() { return mercados; }
}
