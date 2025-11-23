package controller;

import model.Mercado;
import service.ProdutoService;

import java.util.Scanner;

public class ProdutoController {

    private ProdutoService produtoService = new ProdutoService();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto(Mercado mercadoLogado) {

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine();

        produtoService.cadastrar(mercadoLogado, nome, preco, estoque);
        System.out.println("Produto cadastrado!");
    }

    public void listarProdutos(Mercado mercadoLogado) {
        produtoService.listar(mercadoLogado);
    }
}
