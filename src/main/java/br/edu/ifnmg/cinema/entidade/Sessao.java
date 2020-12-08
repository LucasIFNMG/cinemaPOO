package br.edu.ifnmg.cinema.entidade;

import br.edu.ifnmg.cinema.entidade.Filme;

import java.math.BigDecimal;
import java.text.*;
import java.util.ArrayList;

import static br.edu.ifnmg.cinema.entidade.SalaCinema.ASSENTO_DISPONIVEL;
import static br.edu.ifnmg.cinema.entidade.SalaCinema.ASSENTO_OCUPADO;

public class Sessao{
    private Filme filme;
    private String exibicao;
    private String dimensao;
    private SalaCinema sala;
    private int dia;
    private int horario;
    private int assentosDisponiveis;
    private BigDecimal preco;

    public Sessao(Filme filme, String exibicao, String dimensao, SalaCinema sala, int dia, int horario)
    {
        this.filme = filme;
        this.exibicao = exibicao;
        this.dimensao = dimensao;
        this.sala = sala;
        this.dia = dia;
        this.horario = horario;
        this.assentosDisponiveis = sala.getCapacidadeAssentos();
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
    public int getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     * TODO: Verificar os horários já ocupados, no caso de adicionar novos filmes em Cartaz
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * @return the assentosDisponiveis
     */
    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
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
                this.assentosDisponiveis -= quantidade;
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

    public BigDecimal getPreco() {

        switch(this.dia){
            // 1: Domingo
            case 1:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("30.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("26.00");
                    break;
                }
            // 2: Segunda-feira
            case 2:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("20.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("18.00");
                    break;
                }
            // 3: Terça-feira
            case 3:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("22.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("20.00");
                    break;
                }
            // 4: Quarta-feira
            case 4:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("20.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("18.00");
                    break;
                }
            // 5: Quinta-feira
            case 5:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("22.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("20.00");
                    break;
                }
            // 6: Sexta-feira
            case 6:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("22.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("20.00");
                    break;
                }
            // 7: Sábado
            case 7:
                if(this.dimensao == "3D")
                {
                    this.preco = new BigDecimal("30.00");
                    break;
                }
                else
                {
                    this.preco = new BigDecimal("26.00");
                    break;
                }
        }
        return preco;
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
                        // + "\nAssentos Disponíveis: " + this.getAssentosDisponiveis() );
    }

}