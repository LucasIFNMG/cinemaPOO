package br.edu.ifnmg.cinema.entidade;

public class Cliente{
    protected String nome;
    protected String documento;
    protected int idade;

    public Cliente(String nome, String documento, int idade)
    {

        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public Cliente(){};

    public String getNome() {
        return nome;
    }

}