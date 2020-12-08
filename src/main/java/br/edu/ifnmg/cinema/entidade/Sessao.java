package br.edu.ifnmg.cinema.entidade;

import java.text.*;
import java.util.ArrayList;

import static br.edu.ifnmg.cinema.entidade.SalaCinema.ASSENTO_DISPONIVEL;

public class Sessao{

    private static final int SEGUNDA_FEIRA = 1;
    private static final int TERCA_FEIRA = 2;
    private static final int QUARTA_FEIRA = 3;
    private static final int QUINTA_FEIRA = 4;
    private static final int SEXTA_FEIRA = 5;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;

    private static final double PRECO_DIA_UTIL_2D = 20.00;
    private static final double PRECO_DIA_UTIL_3D = 25.00;
    private static final double PRECO_FIM_SEMANA_2D = 25.00;
    private static final double PRECO_FIM_SEMANA_3D = 30.00;

    private int id;
    private Filme filme;
    private String exibicao;
    private String dimensao;
    private SalaCinema sala;
    private int dia;
    private String horario;

    public Sessao(int id, Filme filme, String exibicao, String dimensao, SalaCinema sala, int dia, String horario)
    {
        this.filme = filme;
        this.exibicao = exibicao;
        this.dimensao = dimensao;
        this.sala = sala;
        this.dia = dia;
        this.horario = horario;

    }

    /**
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getExibicao()
    {
        return this.exibicao;
    }

    public void setIsDublado(String exibicao)
    {
        this.exibicao = exibicao;
    }

    public String getDimensao()
    {
        return this.dimensao;
    }

    public void setDimensao(String dimensao)
    {
        this.dimensao = dimensao;
    }

    /**
     * @return the sala
     */
    public SalaCinema getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(SalaCinema sala) {
        this.sala = sala;
    }

    /**
     * @return the dia
    // calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY)
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     * TODO: Verificar os horários já ocupados, no caso de adicionar novos filmes em Cartaz
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean reservarAssentos(int quantidade, int numeroAssento)
    {
        ArrayList<Integer> listaAssentos;
        listaAssentos = getSala().getListaAssentos();
        listaAssentos.ensureCapacity(getSala().getCapacidadeAssentos());

        boolean reservouSucesso = false;

        if(this.getAssentosDisponiveis() >= quantidade)
        {
            if (getSala().getStatusAssento(numeroAssento) == ASSENTO_DISPONIVEL) {
                System.out.println("Assento disponível! Foi reservado!");
                reservouSucesso = true;
            }
            else{
                System.out.println("Assento já está reservado!");
            }

        }
        else if (quantidade > listaAssentos.size() - 1){
            System.out.printf("Capacidade insuficiente! %d < %d", listaAssentos.size() - 1, quantidade);
        }

        return reservouSucesso;
    }

    private int getAssentosDisponiveis() {
        return this.getSala().getCapacidadeAssentos();
    }

    public double getPreco() {

        if (this.getDia() == SEGUNDA_FEIRA ||
                this.getDia() == TERCA_FEIRA ||
                this.getDia() == QUARTA_FEIRA ||
                this.getDia() == QUINTA_FEIRA ||
                this.getDia() == SEXTA_FEIRA){
                    if (this.getDimensao().equals("2D")){
                        return PRECO_DIA_UTIL_2D;
                    }
                    else{
                        return PRECO_DIA_UTIL_3D;
                    }
        } else{
            if (this.getDimensao().equals("2D")){
                return PRECO_FIM_SEMANA_2D;
            } else{
                return PRECO_FIM_SEMANA_3D;
            }
        }

    }

    // Dados Filme + Sessão
    public void recuperarDadosFilmeSessao()   
    {
        this.filme.recuperarDados();
        this.recuperarDadosSessao();
    }

    public void recuperarDadosSessao()
    {
        NumberFormat df = NumberFormat.getCurrencyInstance();
        
        System.out.println("Filme: " +this.filme.getNome()
                        + "\nExibição: " + this.getExibicao()
                        + "\nDimensão: " + this.getDimensao() 
                        + "\nDia: " + this.getDia()
                        + "\nHorário: " + this.getHorario()
                        + "\nPreço: " + df.format(this.getPreco()) 
                        + "\nSala: " + this.sala.getNumeroSala() );
    }

}