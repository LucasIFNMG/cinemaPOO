package br.edu.ifnmg.cinema.entidade;

public class Venda {
    private int id;
    private Ingresso ingresso;
    private Vendedor vendedor;
    public static int numeroVendasCinema = 0;


    public Venda(Ingresso ingresso, Vendedor vendedor){
        this.ingresso = ingresso;
        this.vendedor = vendedor;
        this.id = numeroVendasCinema + 1;

        this.vendedor.incrementarNumeroVendasFuncionario();
        numeroVendasCinema++;
    }

}
