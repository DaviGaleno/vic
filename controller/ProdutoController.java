package controller;

import java.util.Scanner;

import model.Mercado;
import service.MercadoService;
import service.ProdutoService;

public class ProdutoController {

    private Scanner entrada = new Scanner(System.in);
    private ProdutoService produtoService = new ProdutoService();
    private MercadoService mercadoService = new MercadoService();

    public void cadastrarProduto() {

        System.out.print("Nome do mercado onde deseja cadastrar: ");
        String nomeMercado = entrada.nextLine();

        Mercado mercado = mercadoService.buscarPorNome(nomeMercado);

        if (mercado == null) {
            System.out.println("Mercado não encontrado!");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = entrada.nextLine();

        System.out.print("Preço: ");
        double preco = entrada.nextDouble();

        System.out.print("Quantidade: ");
        int qtd = entrada.nextInt();
        entrada.nextLine();

        produtoService.cadastrar(mercado, nome, preco, qtd);
    }

    public void listarProdutos() {
        produtoService.listar();
    }
}
