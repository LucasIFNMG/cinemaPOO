package br.edu.ifnmg.cinema.entidade;

import java.util.ArrayList;

public abstract class Cliente{
    protected String nome;
    protected String documento;
    protected int idade;

    public Cliente(String nome, String cpf, int idade)
    {

        /*
        if(id <= 0)
            throw new IllegalArgumentException(
                "ID inválido!");
        */
        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public Cliente() {

    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the documento
     */
    public String getCpf() {
        return documento;
    }

    /**
     * @param cpf the documento to set
     */
    public void setCpf(String cpf) {
        this.documento = documento;
    }

    public ArrayList<Sessao> visualizarSessoes(){

        ArrayList<Sessao> listaSessoes = new ArrayList<Sessao>();
        // TODO: Recuperar as sessões cadastradas (PLANILHA)
        return listaSessoes;
    }


}