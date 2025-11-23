package controller;

import model.Mercado;
import service.MercadoService;
import service.ProdutoService;
import service.Sessao;

import java.util.Scanner;

public class MercadoController {

    private MercadoService mercadoService;
    private ProdutoService produtoService;
    private Scanner scanner;

    // Construtor que permite injeção de dependências (usado no Main)
    public MercadoController(MercadoService mercadoService, ProdutoService produtoService, Scanner scanner) {
        this.mercadoService = mercadoService;
        this.produtoService = produtoService;
        this.scanner = scanner;
    }

    // Construtor padrão (mantido por compatibilidade)
    public MercadoController() {
        this.mercadoService = new MercadoService();
        this.produtoService = new ProdutoService();
        this.scanner = new Scanner(System.in);
    }

    // === CADASTRAR MERCADO ===
    public void cadastrarMercado() {
        System.out.print("Nome fantasia: ");
        String nome = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // usa o método de serviço que aceita strings
        mercadoService.cadastrar(nome, cnpj, senha);
        System.out.println("Mercado cadastrado com sucesso!");
    }

    // === LOGIN DE MERCADO ===
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

        // registra sessão global para facilitar chamadas sem passar objeto
        Sessao.mercadoLogado = mercado;

        System.out.println("Login realizado com sucesso!");
        return mercado;
    }

    // Versão pública sem parâmetros — utiliza Sessao.mercadoLogado (compatível com Main)
    public void cadastrarProduto() {
        Mercado mercadoLogado = Sessao.mercadoLogado;
        if (mercadoLogado == null) {
            System.out.println("Nenhum mercado logado. Faça login primeiro.");
            return;
        }
        cadastrarProduto(mercadoLogado);
    }

    // Versão pública sem parâmetros para listar produtos
    public void listarProdutos() {
        Mercado mercadoLogado = Sessao.mercadoLogado;
        if (mercadoLogado == null) {
            System.out.println("Nenhum mercado logado. Faça login primeiro.");
            return;
        }
        listarProdutos(mercadoLogado);
    }

    // === cadastrar produto usando o Mercado fornecido ===
    private void cadastrarProduto(Mercado mercadoLogado) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco;
        try {
            preco = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Preço inválido. Operação cancelada.");
            return;
        }

        System.out.print("Estoque: ");
        int estoque;
        try {
            estoque = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Estoque inválido. Operação cancelada.");
            return;
        }

        produtoService.cadastrar(mercadoLogado, nome, preco, estoque);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void listarProdutos(Mercado mercadoLogado) {
        produtoService.listar(mercadoLogado);
    }
}
