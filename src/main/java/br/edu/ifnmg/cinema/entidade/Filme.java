package br.edu.ifnmg.cinema.entidade;

public class Filme{
    private final int id;
    private final String nome;
    private final String genero;
    private int duracaoMinutos;
    private final String censura;
    private final String diretor;
    private static int totalFilmes = 0;

    public Filme(String nome, String genero, int duracaoMinutos, String censura, String diretor)
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
        this.id = totalFilmes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if(duracaoMinutos <= 0)
            throw new IllegalArgumentException(
                "Duração(mins) inválida!");
                
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getCensura() {
        return censura;
    }

    public String getDiretor() {
        return diretor;
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