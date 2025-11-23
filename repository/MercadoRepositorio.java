package repository;

import java.util.ArrayList;
import java.util.List;
import model.Mercado;

public class MercadoRepositorio {

    private List<Mercado> mercados = new ArrayList<>();

    public void salvar(Mercado mercado) {
        mercados.add(mercado);
    }

    public List<Mercado> listar() {
        return mercados;
    }
}

