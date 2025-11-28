package model;

import model.interfaces.ICadastro;

public class Cadastro implements ICadastro {

    protected String nome;
    protected String senha;

    public Cadastro(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getSenha() {
        return senha;
    }
}
