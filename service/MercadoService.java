package service;

import model.Mercado;
import java.util.ArrayList;
import java.util.List;

public class MercadoService {

    private List<Mercado> mercados = new ArrayList<>();

    public void cadastrarMercado(Mercado mercado) {
        mercados.add(mercado);
    }

    public void cadastrar(String nomeFantasia, String cnpj, String senha) {
        Mercado m = new Mercado(nomeFantasia, cnpj, senha);
        cadastrarMercado(m);
    }

    public Mercado login(String cnpj, String senha) {
        for (Mercado m : mercados) {
            if (m.getCnpj().equals(cnpj) && m.getSenha().equals(senha)) {
                return m;
            }
        }
        return null;
    }

    public Mercado buscarPorNome(String nome) {
        for (Mercado m : mercados) {
            if (m.getNomeFantasia().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public List<Mercado> listar() {
        return mercados;
    }
}
