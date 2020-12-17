package br.edu.ifnmg.cinema.entidade;

import java.text.NumberFormat;

public abstract class Funcionario{

    protected String nome;
    protected int id;
    protected String senha;
    protected double salarioBase;
    protected int nivelAcesso;

    public Funcionario(String nome, int id, String senha, double salarioBase, int nivelAcesso)
    {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.salarioBase = salarioBase;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public boolean autenticar(String senha) {
        return this.getSenha().equals(senha);
    }

}