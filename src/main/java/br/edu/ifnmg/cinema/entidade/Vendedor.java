package br.edu.ifnmg.cinema.entidade;

import java.math.BigDecimal;

public class Vendedor extends Funcionario{

    private BigDecimal totalVendido;
    private BigDecimal totalComissao;
    private BigDecimal porcentComissao = new BigDecimal("0.1");
    private double comissao;
    private int numVendasIngressos = 0;

    public Vendedor(String nome, String id, String cpf, BigDecimal salarioBase) {
        super(nome, id, cpf, salarioBase);
    }

    /**
     * @param numVendasIngressos the numVendasIngressos to set
     */
    public void setNumVendasIngressos(int numVendasIngressos) {
        this.numVendasIngressos = numVendasIngressos;
    }

    /**
     * @return the totalVendas
     */
    public int getNumVendasIngressos() {
        return numVendasIngressos;
    }

    /**
     * @param totalVendido the totalVendido to set
     */
    public void setTotalVendido(BigDecimal totalVendido) {
        this.totalVendido = totalVendido;
    }

    /**
     * @return the totalVendido
     */
    public BigDecimal getTotalVendido() {
        return this.totalVendido;
    }

    /**
     * @return the totalVendasCinema
     */
    public static int getNumVendasCinema() {
        return Funcionario.numVendasCinema;
    }

    /**
     * @param numVendasCinema the numVendasCinema to set
     */
    public static void setNumVendasCinema(int numVendasCinema) {
        Funcionario.numVendasCinema = numVendasCinema;
    }
    /*
     * @return the comissao
     */
    public BigDecimal getTotalComissao()
    {
        // totalVendido = this.getTotalVendido();
        this.totalComissao = this.getTotalVendido().multiply(porcentComissao);
        return this.totalComissao;
    }

    /**
     * @param totalArrecadadoCinema the totalArrecadadoCinema to set
     */
    public static void setTotalArrecadadoCinema(BigDecimal totalArrecadadoCinema) {
        Funcionario.totalArrecadadoCinema = totalArrecadadoCinema;
    }

    /**
     * @return the totalArrecadadoCinema
     */
    public static BigDecimal getTotalArrecadadoCinema() {
        return Funcionario.totalArrecadadoCinema;
    }

    public boolean venderIngresso(Sessao sessao, int quantidade, int numeroAssento)
    {
        boolean reservouSucesso = sessao.reservarAssentos(quantidade, numeroAssento);

        if(reservouSucesso)
        {
            // Incrementa o nº de Vendas do Funcionário e o nº de Vendas do Cinema
            this.setNumVendasIngressos(this.getNumVendasIngressos() + quantidade);
            Vendedor.setNumVendasCinema(Vendedor.getNumVendasCinema() + quantidade);

            // Incrementa o valor($) arrecadado pelo Funcionário e pelo Cinema
            BigDecimal valorVenda = sessao.getPreco().multiply(BigDecimal.valueOf(quantidade));
            this.setTotalVendido(valorVenda.add(this.getTotalVendido()));
            Vendedor.setTotalArrecadadoCinema(valorVenda.add(Vendedor.getTotalArrecadadoCinema()));
            System.out.println("Ingresso(s) reservado(s) com sucesso!");
            return true;
        }
        else
        {
            System.out.println("NÃO foi possível reservar o(s) ingresso(s)!");
            return false;
        }
    }

}
