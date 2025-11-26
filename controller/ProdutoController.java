package controller;

import enums.CategoriaProduto;
import model.Mercado;
import service.ProdutoService;
import service.Sessao;

import java.util.Scanner;

public class ProdutoController {

    private ProdutoService produtoService;
    private Scanner scanner;

    public ProdutoController(ProdutoService produtoService, Scanner scanner) {
        this.produtoService = produtoService;
        this.scanner = scanner;
    }

    public void cadastrarProduto() {

        Mercado mercadoLogado = Sessao.mercadoLogado;

        if (mercadoLogado == null) {
            System.out.println("Nenhum mercado logado! Faça login primeiro.");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco;
        try {
            preco = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Preço inválido!");
            return;
        }

        System.out.print("Estoque: ");
        int estoque;
        try {
            estoque = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Estoque inválido!");
            return;
        }

        System.out.println("\nSelecione a categoria:");
        for (CategoriaProduto c : CategoriaProduto.values()) {
            System.out.println(c.ordinal() + " - " + c);
        }

        System.out.print("Escolha a categoria: ");
        int catIndex;
        try {
            catIndex = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Categoria inválida!");
            return;
        }

        if (catIndex < 0 || catIndex >= CategoriaProduto.values().length) {
            System.out.println("Categoria inexistente!");
            return;
        }

        CategoriaProduto categoria = CategoriaProduto.values()[catIndex];

        produtoService.cadastrar(mercadoLogado, nome, preco, estoque, categoria);

        System.out.println("Produto cadastrado com sucesso!");
    }
}
