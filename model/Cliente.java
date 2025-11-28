package model;

import model.interfaces.ICliente;

public class Cliente extends Cadastro implements ICliente {

    private String cpf;
    private int idade;

    public Cliente(String nome, String cpf, int idade, String senha) {
        super(nome, senha);
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | Idade: " + idade;
    }
}
