package service;

import model.Cliente;
import model.Mercado;

public class Sessao {

    public static Mercado mercadoLogado = null;
    public static Cliente clienteLogado = null;

    public static void sair() {
        mercadoLogado = null;
        clienteLogado = null;
    }
}
