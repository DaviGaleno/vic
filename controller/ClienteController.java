package controller;

import model.Cliente;
import model.Compra;
import model.ItemCompra;
import model.Venda;
import service.ClienteService;
import service.Sessao;
import service.VendaService;

import java.util.Scanner;

public class ClienteController {

    private ClienteService clienteService;
    private VendaService vendaService;
    private Scanner scanner;

    public ClienteController(ClienteService clienteService, VendaService vendaService, Scanner scanner) {
        this.clienteService = clienteService;
        this.vendaService = vendaService;
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
            System.out.println("1 - Consultar Produtos");
            System.out.println("2 - Realizar Compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    consultarProdutos();
                    break;

                case 2:
                    realizarCompra(clienteLogado);
                    break;

                case 0:
                    System.out.println("Saindo do menu do cliente...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void consultarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS DE TODOS OS MERCADOS ===");

        for (var mercado : service.MercadoService.getMercadosStatic()) {
            System.out.println("\n--- Mercado: " + mercado.getNome() + " ---");
            for (var p : mercado.getProdutos()) {
                System.out.println(p);
            }
        }
    }

    private void realizarCompra(Cliente clienteLogado) {

        Compra compra = new Compra(clienteLogado);

        while (true) {
            System.out.println("\nDigite o nome do produto (ou 0 para finalizar): ");
            String nome = scanner.nextLine();

            if (nome.equals("0")) break;

            var produto = service.MercadoService.buscarProdutoGlobal(nome);

            if (produto == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd;

            try {
                qtd = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Quantidade inválida.");
                continue;
            }

            if (qtd > produto.getEstoque()) {
                System.out.println("Estoque insuficiente!");
                continue;
            }

            produto.reduzirEstoque(qtd);
            compra.adicionarItem(new ItemCompra(produto, qtd));

            System.out.println("Produto adicionado ao carrinho!");
        }

        if (compra.getItens().isEmpty()) {
            System.out.println("Nenhum item comprado.");
            return;
        }

        Sessao.compraService.registrarCompra(compra);

        // === REGISTRAR VENDAS CORRETAMENTE ===
        for (var item : compra.getItens()) {
            vendaService.registrarVenda(
                    item.getProduto().getMercado(),
                    new Venda(
                            item.getProduto().getNome(),
                            item.getQuantidade(),
                            item.getProduto().getPreco(),
                            clienteLogado
                    )
            );
        }

        System.out.println("COMPRA FINALIZADA!");
        System.out.println("Total: R$ " + compra.getTotal());
    }
}
