package br.edu.ifnmg.cinema.entidade;

import java.util.ArrayList;

public class SalaCinema{

    private final int numeroSala;
    private final int capacidadeAssentos;
    private final ArrayList<Integer> listaAssentos = new ArrayList<>();

    static final int ASSENTO_DISPONIVEL = 0;
    static final int ASSENTO_OCUPADO = 1;

    public SalaCinema(int numeroSala, int capacidadeAssentos)
    {
        this.numeroSala = numeroSala;
        this.capacidadeAssentos = capacidadeAssentos;
        this.listaAssentos.ensureCapacity(capacidadeAssentos);
        setTodosAssentosDisponiveis();
    }

    public void setTodosAssentosDisponiveis() {

        for (int i = 0; i < this.capacidadeAssentos; i++){
            listaAssentos.add(ASSENTO_DISPONIVEL);
        }
    }

    public int getStatusAssento(int numeroAssento){
        return listaAssentos.get(numeroAssento);
    }

    public void reservarAssento(int numeroAssento){

        if (getStatusAssento(numeroAssento) == ASSENTO_DISPONIVEL){
            listaAssentos.set(numeroAssento, ASSENTO_OCUPADO);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSalaLotada(){

        for (Integer assento : listaAssentos){
            if (assento == ASSENTO_DISPONIVEL){
                return false;
            }
        }
        return true;
    }

    public void imprimirAssentosDisponiveis(){

        for (int i = 0; i < listaAssentos.size(); i++)
        {
            int assento = listaAssentos.get(i);
            if (assento == ASSENTO_DISPONIVEL){
                System.out.printf("%d ", i + 1);
            }

        }

        System.out.println();
    }

    public void verificarAssento(int opcaoAssento) {
        if (opcaoAssento < 0 || opcaoAssento > this.capacidadeAssentos){
            throw new IllegalArgumentException();
        } else{
            reservarAssento(opcaoAssento);
        }
    }
}