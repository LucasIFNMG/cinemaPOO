package br.edu.ifnmg.cinema.entidade;

import javax.xml.crypto.Data;

public class Filme{
    private int id;
    private String nome;
    private String genero;
    private int duracaoMinutos;
    private String censura;
    private String diretor;
    private static int totalFilmes = 0;

    public Filme(int id, String nome, String genero, int duracaoMinutos, String censura, String diretor)
    {

        if(duracaoMinutos <= 0)
            throw new IllegalArgumentException(
                "Duração(mins) inválida!");

        this.nome = nome;
        this.genero = genero;
        this.duracaoMinutos = duracaoMinutos;
        this.censura = censura;
        this.diretor = diretor;
        Filme.totalFilmes++;
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the duracao
     */
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    /**
     * @param duracaoMinutos the duracao to set
     */
    public void setDuracaoMinutos(int duracaoMinutos) {
        if(duracaoMinutos <= 0)
            throw new IllegalArgumentException(
                "Duração(mins) inválida!");
                
        this.duracaoMinutos = duracaoMinutos;
    }

    /**
     * @return the censura
     */
    public String getCensura() {
        return censura;
    }

    /**
     * @param censura the censura to set
     */
    public void setCensura(String censura) {
        this.censura = censura;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the totalFilmes
     */
    public static int getTotalFilmes() {
        return Filme.totalFilmes;
    }

    public void recuperarDados()
    {
        System.out.println("Filme: " + this.getNome()
                        + "\nGênero: " + this.getGenero()
                        + "\nDuração: " + this.getDuracaoMinutos() + " mins"
                        + "\nCensura: " + this.getCensura()
                        + "\nDiretor: " + this.getDiretor());
    }

}