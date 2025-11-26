package model;

public class Cliente extends Cadastro {

    private String cpf;
    private int idade;

    public Cliente(String nome, String cpf, int idade, String senha) {
        super(nome, senha);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | Idade: " + idade;
    }
}
