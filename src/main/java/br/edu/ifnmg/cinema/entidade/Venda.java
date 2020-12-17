package br.edu.ifnmg.cinema.entidade;

public class Venda {
    private int id;
    protected Ingresso ingresso;
    private Vendedor vendedor;
    protected static int numeroVendasCinema = 0;

    public Venda(Ingresso ingresso, Vendedor vendedor){
        this.ingresso = ingresso;
        this.vendedor = vendedor;
        this.id = numeroVendasCinema + 1;

        double valorVenda = this.getIngresso().getPreco();
        this.getVendedor().incrementarTotalVendidoFuncionario(valorVenda);

        this.getVendedor().incrementarNumeroVendasFuncionario();
        numeroVendasCinema++;
    }

    public Venda(Ingresso ingresso){
        this.ingresso = ingresso;
    }

    public int getId() {
        return id;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
}
