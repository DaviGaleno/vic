package controller;

import model.Cliente;
import service.ClienteService;

import java.util.Scanner;

public class ClienteController {

    private ClienteService clienteService;
    private Scanner scanner;

    // CONSTRUTOR COMPATÍVEL COM A MAIN
    public ClienteController(ClienteService clienteService, Scanner scanner) {
        this.clienteService = clienteService;
        this.scanner = scanner;
    }

    public void cadastrarCliente() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        clienteService.cadastrar(nome, cpf, idade, senha);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente loginCliente() {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = clienteService.login(cpf, senha);

        if (cliente == null) {
            System.out.println("CPF ou senha inválidos!");
        } else {
            System.out.println("Login realizado com sucesso!");
        }

        return cliente;
    }

    public void menuCliente(Cliente clienteLogado) {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU DO CLIENTE " + clienteLogado.getNome() + " =====");
            System.out.println("1 - Consultar Produtos (Sprint 3)");
            System.out.println("2 - Realizar Compra (Sprint 3)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> System.out.println("Função disponível na Sprint 3");
                case 2 -> System.out.println("Função disponível na Sprint 3");
                case 0 -> System.out.println("Saindo do menu do cliente...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
