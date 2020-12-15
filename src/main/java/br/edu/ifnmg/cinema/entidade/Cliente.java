package br.edu.ifnmg.cinema.entidade;

import java.util.ArrayList;

public abstract class Cliente{
    protected String nome;
    protected String documento;
    protected int idade;

    public Cliente(String nome, String documento, int idade)
    {

        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void visualizarSessoes(){

        ArrayList<Sessao> listaSessoes = new ArrayList<>();
        // TODO: Recuperar as sessões cadastradas (PLANILHA)
    }


}