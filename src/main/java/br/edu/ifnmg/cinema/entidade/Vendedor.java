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
    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    /**
     * @return the totalVendido
     */
    public double getTotalVendido() {
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
    public double getTotalComissao()
    {
        // totalVendido = this.getTotalVendido();
        this.totalComissao = getTotalVendido() * porcentComissao;
        return this.totalComissao;
    }

    /**
     * @param totalArrecadadoCinema the totalArrecadadoCinema to set
     */
    public static void setTotalArrecadadoCinema(double totalArrecadadoCinema) {
        Funcionario.totalArrecadadoCinema = totalArrecadadoCinema;
    }

    /**
     * @return the totalArrecadadoCinema
     */
    public static double getTotalArrecadadoCinema() {
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
            double valorVenda = sessao.getPreco() * quantidade;
            this.setTotalVendido(valorVenda + this.getTotalVendido());
            Vendedor.setTotalArrecadadoCinema(valorVenda + Vendedor.getTotalArrecadadoCinema());
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
