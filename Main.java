import java.util.Scanner;

import controller.ClienteController;
import controller.MercadoController;
import model.Cliente;
import service.ClienteService;
import service.MercadoService;
import service.ProdutoService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Serviços do sistema
        MercadoService mercadoService = new MercadoService();
        ProdutoService produtoService = new ProdutoService();
        ClienteService clienteService = new ClienteService();

        // Controllers
        MercadoController mercadoController = new MercadoController(mercadoService, produtoService, sc);
        ClienteController clienteController = new ClienteController(clienteService, sc);

        int opc = -1;

        while (opc != 0) {

            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Menu do Mercado");
            System.out.println("2 - Menu do Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opc = -1;
            }

            switch (opc) {
                case 1:
                    menuMercado(mercadoController, sc);
                    break;

                case 2:
                    menuCliente(clienteController, sc);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    private static void menuMercado(MercadoController controller, Scanner sc) {

        int op = -1;

        while (op != 0) {

            System.out.println("\n=== MENU DO MERCADO ===");
            System.out.println("1 - Cadastrar Mercado");
            System.out.println("2 - Login Mercado");
            System.out.println("3 - Cadastrar Produto (precisa estar logado)");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                op = -1;
            }

            switch (op) {

                case 1:
                    controller.cadastrarMercado();
                    break;

                case 2:
                    controller.loginMercado();
                    break;

                case 3:
                    controller.cadastrarProduto();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuCliente(ClienteController controller, Scanner sc) {

        int op = -1;

        while (op != 0) {

            System.out.println("\n=== MENU DO CLIENTE ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Login Cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                op = -1;
            }

            switch (op) {

                case 1:
                    controller.cadastrarCliente();
                    break;

                case 2:
                    Cliente cliente = controller.loginCliente();
                    if (cliente != null) {
                        controller.menuCliente(cliente);
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
