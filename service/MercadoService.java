package service;

import java.util.ArrayList;
import java.util.List;
import model.Mercado;
import model.Produto;

public class MercadoService {

    private List<Mercado> mercados = new ArrayList<>();

    public void cadastrar(String nomeFantasia, String cnpj, String senha) {
        Mercado m = new Mercado(nomeFantasia, cnpj, senha);
        mercados.add(m);
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
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public static List<Mercado> mercadosStatic = new ArrayList<>();

    public MercadoService() {
        mercadosStatic = mercados;
    }

    public static List<Mercado> getMercadosStatic() {
        return mercadosStatic;
    }

    public static Produto buscarProdutoGlobal(String nome) {
        for (Mercado m : mercadosStatic) {
            for (Produto p : m.getProdutos()) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    return p;
                }
            }
        }
        return null;
    }

    public List<Mercado> listar() {
        return mercados;
    }
}
