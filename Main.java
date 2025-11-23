import controller.ClienteController;
import controller.MercadoController;
import controller.ProdutoController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ClienteController clienteController = new ClienteController();
        MercadoController mercadoController = new MercadoController();
        ProdutoController produtoController = new ProdutoController();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar mercado");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Cadastrar cliente");
            System.out.println("4 - Listar mercados");
            System.out.println("5 - Listar produtos");
            System.out.println("6 - Listar clientes");
            System.out.println("0 - Sair");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1: mercadoController.cadastrarMercado(); break;
                case 2: produtoController.cadastrarProduto(); break;
                case 3: clienteController.cadastrarCliente(); break;
                case 4: mercadoController.listarMercados(); break;
                case 5: produtoController.listarProdutos(); break;
                case 6: clienteController.listarClientes(); break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        entrada.close();
    }
}
