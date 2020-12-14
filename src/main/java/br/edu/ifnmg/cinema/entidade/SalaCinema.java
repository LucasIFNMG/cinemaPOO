package br.edu.ifnmg.cinema.entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SalaCinema{

    private final int numeroSala;
    private final int capacidadeAssentos;
    private ArrayList<Integer> listaAssentos = new ArrayList<>();

    static final int ASSENTO_DISPONIVEL = 0;
    static final int ASSENTO_OCUPADO = 1;

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

    public ArrayList<Integer> getListaAssentos(){
        return this.listaAssentos;
    }

    public int getNumeroSala() {
        return this.numeroSala;
    }

    public void setListaAssentos(ArrayList<Integer> listaAssentos) {
        this.listaAssentos = listaAssentos;
    }

    public int getCapacidadeAssentos() {
        return capacidadeAssentos;
    }

    public int getStatusAssento(int numeroAssento){
        return listaAssentos.get(numeroAssento);
    }

    public void setStatusAssento(int numeroAssento, int statusAssento){
        listaAssentos.set(numeroAssento,statusAssento);
    }

    public void reservarAssento(int numeroAssento){

        if (getStatusAssento(numeroAssento) == ASSENTO_OCUPADO){
            // TODO: Exception
            System.out.println("ERRO! Esta vaga já está ocupada!");
        } else{
            listaAssentos.set(numeroAssento, ASSENTO_OCUPADO);
        }
    }

    public boolean isSalaLotada(){
        // Getting ListIterator
        ListIterator<Integer> intIterator = listaAssentos.listIterator();

        /* Traversing elements
        while(intIterator.hasNext()){
            System.out.println(intIterator.next());
        }
         */
        // Enhanced for loop creates Internal Iterator here.
        for(Integer statusAssento : listaAssentos){
            if(statusAssento == ASSENTO_DISPONIVEL){
                return false;
            }
        }
        return true;
    }

    public void imprimirAssentosDisponiveis(){
        //ArrayList<Integer> listaAssentos = getListaAssentos();
        for(Integer assento : listaAssentos){
            if(assento == ASSENTO_DISPONIVEL){
                System.out.printf("%d ", assento);
            }
        }


    }
}