package br.edu.ifnmg.cinema.entidade;

public class Ingresso
{
    // No caso de Meia-entrada ou Reserva, deve-se pedir os dados do cliente
    private Sessao sessao;
    private boolean isMeiaEntrada;
    private double preco;
    private int numeroAssento;

    public Ingresso(Sessao sessao, boolean isMeiaEntrada, int numeroAssento)
    {
        this.sessao = sessao;
        this.isMeiaEntrada = isMeiaEntrada;
        this.preco = sessao.getPreco();
        this.numeroAssento = numeroAssento;

    }

    public double getPreco(){
        double precoIngresso = this.preco;
        if (this.isMeiaEntrada){
            precoIngresso = this.sessao.getPreco() * 1/2;
        }
        return precoIngresso;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public void imprimirIngresso(){
        this.sessao.imprimirFilmeDiaHorarioSessao();
        System.out.println("Assento: " + this.getNumeroAssento());
    }
}