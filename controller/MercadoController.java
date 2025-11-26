package controller;

import enums.CategoriaProduto;
import model.Mercado;
import model.Venda;
import service.MercadoService;
import service.ProdutoService;
import service.Sessao;
import service.VendaService;

import java.util.Scanner;

public class MercadoController {

    private MercadoService mercadoService;
    private ProdutoService produtoService;
    private VendaService vendaService;
    private Scanner scanner;

    public MercadoController(MercadoService mercadoService, ProdutoService produtoService, VendaService vendaService, Scanner scanner) {
        this.mercadoService = mercadoService;
        this.produtoService = produtoService;
        this.vendaService = vendaService;
        this.scanner = scanner;
    }

    public void cadastrarMercado() {
        System.out.print("Nome fantasia: ");
        String nome = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        mercadoService.cadastrar(nome, cnpj, senha);
        System.out.println("Mercado cadastrado com sucesso!");
    }

    public Mercado loginMercado() {
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Mercado mercado = mercadoService.login(cnpj, senha);

        if (mercado == null) {
            System.out.println("CNPJ ou senha inválidos!");
            return null;
        }

        Sessao.mercadoLogado = mercado;
        System.out.println("Login realizado com sucesso!");
        return mercado;
    }

    public void cadastrarProduto() {
        Mercado mercado = Sessao.mercadoLogado;

        if (mercado == null) {
            System.out.println("Nenhum mercado logado.");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Estoque: ");
        int estoque = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSelecione a categoria:");
        int i = 1;
        for (CategoriaProduto c : CategoriaProduto.values()) {
            System.out.println(i + " - " + c);
            i++;
        }
        System.out.print("Opção: ");

        int opc = Integer.parseInt(scanner.nextLine());
        CategoriaProduto categoria = CategoriaProduto.values()[opc - 1];

        produtoService.cadastrar(mercado, nome, preco, estoque, categoria);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void relatorioVendas() {

        Mercado mercadoLogado = Sessao.mercadoLogado;
        if (mercadoLogado == null) {
            System.out.println("Nenhum mercado logado.");
            return;
        }

        System.out.println("\n===== RELATÓRIO DE VENDAS — " + mercadoLogado.getNome() + " =====");

        var vendas = vendaService.listarVendas(mercadoLogado);

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
            return;
        }

        for (Venda v : vendas) {
            System.out.println("\nProduto: " + v.getNomeProduto());
            System.out.println("Quantidade: " + v.getQuantidade());
            System.out.println("Preço Unitário: R$" + v.getPrecoUnitario());
            System.out.println("Total da Venda: R$" + v.getTotalVenda());
            System.out.println("Cliente: " + v.getCliente().getNome());
        }

        double total = vendaService.calcularTotalFaturado(mercadoLogado);
        System.out.println("\n💰 FATURAMENTO TOTAL: R$ " + total);
    }


    public void listarProdutos() {
        Mercado mercado = Sessao.mercadoLogado;

        if (mercado == null) {
            System.out.println("Nenhum mercado logado.");
            return;
        }


        produtoService.listar(mercado);
    }
}
