package br.edu.ifnmg.cinema.entidade;

public class Vendedor extends Funcionario{

    private double totalVendido;
    private double totalComissao;
    private double porcentComissao = 0.1;
    private double comissao;
    private int numVendasIngressos = 0;

    public Vendedor(String nome, String id, String senha, double salarioBase, int nivelAcesso) {
        super(nome, id, senha, salarioBase, nivelAcesso);
    }

    public void setNumVendasIngressos(int numVendasIngressos) {
        this.numVendasIngressos = numVendasIngressos;
    }

    public int getNumVendasIngressos() {
        return numVendasIngressos;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public double getTotalVendido() {
        return this.totalVendido;
    }

    public double getTotalComissao()
    {
        // totalVendido = this.getTotalVendido();
        this.totalComissao = getTotalVendido() * porcentComissao;
        return this.totalComissao;
    }

    public void incrementarNumeroVendasFuncionario(){
        this.numVendasIngressos++;
    }

}
