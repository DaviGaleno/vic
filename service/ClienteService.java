package service;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();


    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrar(String nome, String cpf, int idade, String senha) {
        Cliente cliente = new Cliente(nome, cpf, idade, senha);
        clientes.add(cliente);
    }

    public Cliente login(String cpf, String senha) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clientes;
    }
}
