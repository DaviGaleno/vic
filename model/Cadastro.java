package model;

public abstract class Cadastro {

    protected String nome;
    protected String senha;

    public Cadastro(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
