package br.edu.ifnmg.cinema.entidade;

import java.util.ArrayList;

public class SalaCinema{

    private int numeroSala;
    private int capacidadeAssentos;
    private final ArrayList<Integer> listaAssentos = new ArrayList<>();


    static final int ASSENTO_DISPONIVEL = 0;
    static final int ASSENTO_OCUPADO = 1;

    public ArrayList<Integer> getListaAssentos(){
        return this.listaAssentos;
    }

    public SalaCinema(int numeroSala, int capacidadeAssentos)
    {
        if(numeroSala <= 0)
            throw new IllegalArgumentException(
                "Nº da Sala deve ser > 0 !");

        if(capacidadeAssentos <= 0)
            throw new IllegalArgumentException(
                "Nº de Assentos deve ser > 0!");
        
        this.numeroSala = numeroSala;
        this.capacidadeAssentos = capacidadeAssentos;
    }

    /**
     * @return the numero
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * @return the capacidadeAssentos
     */
    public int getCapacidadeAssentos() {
        return capacidadeAssentos;
    }

    public int getStatusAssento(int numeroAssento){
        return listaAssentos.get(numeroAssento);
    }

    public void reservarAssento(int numeroAssento, int ASSENTO_OCUPADO){
        getListaAssentos().set(numeroAssento, ASSENTO_OCUPADO);
    }
}