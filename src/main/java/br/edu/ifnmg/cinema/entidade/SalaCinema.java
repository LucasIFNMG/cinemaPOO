package br.edu.ifnmg.cinema.entidade;

public class SalaCinema{
    private final int numeroSala;
    private final int capacidadeAssentos;

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

}