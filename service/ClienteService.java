package service;

import model.Cliente;
import repository.ClienteRepositorio;

public class ClienteService {

    private ClienteRepositorio repo = new ClienteRepositorio();

    public void cadastrar(String nome, String cpf) {
        Cliente c = new Cliente(nome, cpf);
        repo.salvar(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listar() {
        for (Cliente c : repo.listar()) {
            System.out.println(c);
        }
    }
}


