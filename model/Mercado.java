package model;

import model.interfaces.IMercado;

import java.util.ArrayList;
import java.util.List;

public class Mercado extends Cadastro implements IMercado {

    private String cnpj;
    private List<Produto> produtos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public Mercado(String nomeFantasia, String cnpj, String senha) {
        super(nomeFantasia, senha);
        this.cnpj = cnpj;
    }

    public void gerarRelatorio() {

        System.out.println("\n===== RELATÓRIO DO MERCADO =====");
        System.out.println("Mercado: " + nome);
        System.out.println("CNPJ: " + cnpj);

        double faturamentoTotal = 0.0;
        int totalItensVendidos = 0;

        List<String> nomesProdutosVendidos = new ArrayList<>();
        List<Integer> qtdsProdutosVendidos = new ArrayList<>();
        List<Double> faturamentoPorProduto = new ArrayList<>();

        List<Cliente> clientesUnicos = new ArrayList<>();
        List<Integer> qtdComprasPorCliente = new ArrayList<>();
        List<Double> gastoPorCliente = new ArrayList<>();

        for (Venda v : vendas) {
            faturamentoTotal += v.getTotalVenda();
            totalItensVendidos += v.getQuantidade();

            String nomeProd = v.getNomeProduto();
            double totalVendaProduto = v.getTotalVenda();
            int quantidadeVenda = v.getQuantidade();

            int idxProd = -1;
            for (int i = 0; i < nomesProdutosVendidos.size(); i++) {
                if (nomesProdutosVendidos.get(i).equalsIgnoreCase(nomeProd)) {
                    idxProd = i;
                    break;
                }
            }
            if (idxProd == -1) {
                nomesProdutosVendidos.add(nomeProd);
                qtdsProdutosVendidos.add(quantidadeVenda);
                faturamentoPorProduto.add(totalVendaProduto);
            } else {
                qtdsProdutosVendidos.set(idxProd, qtdsProdutosVendidos.get(idxProd) + quantidadeVenda);
                faturamentoPorProduto.set(idxProd, faturamentoPorProduto.get(idxProd) + totalVendaProduto);
            }

            Cliente cliente = v.getCliente();
            int idxCli = -1;
            for (int i = 0; i < clientesUnicos.size(); i++) {
                if (clientesUnicos.get(i).equals(cliente)) {
                    idxCli = i;
                    break;
                }
            }
            if (idxCli == -1) {
                clientesUnicos.add(cliente);
                qtdComprasPorCliente.add(1);
                gastoPorCliente.add(v.getTotalVenda());
            } else {
                qtdComprasPorCliente.set(idxCli, qtdComprasPorCliente.get(idxCli) + 1);
                gastoPorCliente.set(idxCli, gastoPorCliente.get(idxCli) + v.getTotalVenda());
            }
        }

        String produtoMaisVendido = null;
        int maiorQtdVendida = 0;

        String produtoMaisLucrativo = null;
        double maiorFaturamentoProduto = 0.0;

        for (int i = 0; i < nomesProdutosVendidos.size(); i++) {
            String nomeP = nomesProdutosVendidos.get(i);
            int qtd = qtdsProdutosVendidos.get(i);
            double fatur = faturamentoPorProduto.get(i);

            if (qtd > maiorQtdVendida) {
                maiorQtdVendida = qtd;
                produtoMaisVendido = nomeP;
            }

            if (fatur > maiorFaturamentoProduto) {
                maiorFaturamentoProduto = fatur;
                produtoMaisLucrativo = nomeP;
            }
        }

        Cliente clienteTop = null;
        double maiorGasto = 0.0;
        int clienteMaisCompras = 0;
        Cliente clienteMaisComprasObj = null;

        for (int i = 0; i < clientesUnicos.size(); i++) {
            double gasto = gastoPorCliente.get(i);
            int compras = qtdComprasPorCliente.get(i);

            if (gasto > maiorGasto) {
                maiorGasto = gasto;
                clienteTop = clientesUnicos.get(i);
            }

            if (compras > clienteMaisCompras) {
                clienteMaisCompras = compras;
                clienteMaisComprasObj = clientesUnicos.get(i);
            }
        }

        System.out.println();
        System.out.println("Total de vendas registradas: " + vendas.size());
        System.out.println("Total de itens vendidos: " + totalItensVendidos);
        System.out.printf("Faturamento total: R$ %.2f\n", faturamentoTotal);

        if (produtoMaisVendido != null) {
            System.out.println("\n Produto mais vendido: " + produtoMaisVendido + " (" + maiorQtdVendida + " unidades)");
        } else {
            System.out.println("\n Produto mais vendido: nenhum registro ainda.");
        }

        if (produtoMaisLucrativo != null) {
            System.out.printf(" Produto com maior faturamento: %s (R$ %.2f)\n", produtoMaisLucrativo, maiorFaturamentoProduto);
        }

        if (clienteTop != null) {
            System.out.printf("\n Cliente que mais gastou: %s (CPF: %s) — Total gasto: R$ %.2f\n",
                    clienteTop.getNome(), clienteTop.getCpf(), maiorGasto);
        } else {
            System.out.println("\n Cliente que mais gastou: nenhum registro ainda.");
        }

        if (clienteMaisComprasObj != null) {
            System.out.println("🛒 Cliente com mais compras (quantidade de compras): " +
                    clienteMaisComprasObj.getNome() + " (" + clienteMaisCompras + " compras)");
        }

        System.out.println("\n----- Estoque Atual -----");
        if (produtos.isEmpty()) {
            System.out.println("Sem produtos cadastrados.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p.getNome() + " - " + p.getEstoque() + " unidades");
            }
        }

        System.out.println("\n----- Total vendido por produto -----");
        if (nomesProdutosVendidos.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (int i = 0; i < nomesProdutosVendidos.size(); i++) {
                System.out.println(nomesProdutosVendidos.get(i) + ": " + qtdsProdutosVendidos.get(i) + " unidades vendidas" +
                        String.format(" (R$ %.2f)", faturamentoPorProduto.get(i)));
            }
        }

        System.out.println("\n----- Vendas Realizadas -----");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda v : vendas) {
                System.out.println("Produto: " + v.getNomeProduto()
                        + " | Quantidade: " + v.getQuantidade()
                        + " | Total: R$ " + v.getTotalVenda()
                        + " | Cliente: " + v.getCliente().getNome());
            }
        }

        System.out.println("\n===== FIM DO RELATÓRIO =====\n");
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

    @Override
    public Produto buscarProdutoPorNome(String nome) {
        if (nome == null) return null;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produto.setMercado(this);
        produtos.add(produto);
    }

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    @Override
    public String toString() {
        return "Mercado: " + nome + " | CNPJ: " + cnpj;
    }
}
