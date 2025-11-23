package service;

import model.Mercado;
import repository.MercadoRepositorio;

public class MercadoService {

    private MercadoRepositorio repo = new MercadoRepositorio();

    public void cadastrar(String nome, String cnpj) {
        Mercado mercado = new Mercado(nome, cnpj);
        repo.salvar(mercado);
        System.out.println("Mercado cadastrado com sucesso!");
    }

    public void listar() {
        for (Mercado m : repo.listar()) {
            System.out.println(m);
        }
    }

    public Mercado buscarPorNome(String nome) {
        for (Mercado m : repo.listar()) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }
}
