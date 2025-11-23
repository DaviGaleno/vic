package controller;

import java.util.Scanner;
import service.ClienteService;

public class ClienteController {

    private Scanner entrada = new Scanner(System.in);
    private ClienteService service = new ClienteService();

    public void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        service.cadastrar(nome, cpf);
    }

    public void listarClientes() {
        service.listar();
    }
}

