package controller;

import java.util.Scanner;
import service.MercadoService;

public class MercadoController {

    private MercadoService service = new MercadoService();
    private Scanner entrada = new Scanner(System.in);

    public void cadastrarMercado() {
        System.out.print("Nome do mercado: ");
        String nome = entrada.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = entrada.nextLine();

        service.cadastrar(nome, cnpj);
    }

    public void listarMercados() {
        service.listar();
    }

    public MercadoService getService() {
        return service;
    }
}

