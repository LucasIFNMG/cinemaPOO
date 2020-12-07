package br.edu.ifnmg.cinema.entidade;

import javax.xml.crypto.Data;

public class Cartaz
{
    Sessao sessao;
    Data dataInicio;
    Data dataTermino;

    public Cartaz(Sessao sessao)
    {
        this.sessao = sessao;
    }

    /**
     * @return the filme
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * @param sessao the filme to set
     */
    public void setFilme(Sessao sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the dataInicio
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataTermino
     */
    public Data getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Data dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void recuperarSessoes()
    {
        System.out.println("Filmes em Cartaz: ");
        this.getSessao().recuperarDadosSessao();
        // System.out.println(this.getSessao().getSala().getNumeroSala());
    }

}