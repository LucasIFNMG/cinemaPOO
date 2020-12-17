package br.edu.ifnmg.cinema.entidade;

public class Vendedor extends Funcionario{

    private static final double DEZ_PORCENTO = 0.1;

    private double totalVendido;
    private double comissao;
    private int numVendasIngressos;

    public Vendedor(String nome, int id, String senha, double salarioBase, int nivelAcesso) {
        super(nome, id, senha, salarioBase, nivelAcesso);
        this.numVendasIngressos = 0;
        this.totalVendido = 0;
    }

    public int getNumVendasIngressos() {
        return numVendasIngressos;
    }

    public double getTotalVendido() {
        return this.totalVendido;
    }

    public void incrementarTotalVendidoFuncionario(double valor){
        this.totalVendido += valor;
    }

    public double getTotalComissao()
    {
        return getTotalVendido() * DEZ_PORCENTO;
    }

    public void incrementarNumeroVendasFuncionario(){
        this.numVendasIngressos++;
    }

}
