import java.math.BigDecimal;
import java.text.NumberFormat;

class Funcionario
{
    private final String nome;
    private int id;
    private final String cpf;
    private int numVendasIngressos = 0;
    private BigDecimal salarioBase;
    private BigDecimal totalVendido;
    private BigDecimal totalComissao;
    private BigDecimal porcentComissao = new BigDecimal("0.1");
    private static int numVendasCinema = 0;
    private static BigDecimal totalArrecadadoCinema;
    

    public Funcionario(String nome, int id, String cpf, BigDecimal salarioBase)
    {

        if (id <= 0)
            throw new IllegalArgumentException(
                "ID inválido!");
        
            // compareTo: retorna -1, 0 ou 1. -1: 1º parâmetro MENOR do que o 2º. 0: 1º == 2º. 1: 1º > 2º.
        if(salarioBase.compareTo(BigDecimal.ZERO) == -1)
            throw new IllegalArgumentException(
                "Salário-base deve ser >= 0! ");

        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        // this.nivelAcesso = 0;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
     * @param totalVendasCinema the totalVendasCinema to set
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

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(BigDecimal salarioBase)
    {
        if(salarioBase.compareTo(BigDecimal.ZERO) == -1)
            throw new IllegalArgumentException(
                "Salário-base deve ser >= 0! ");
        
        this.salarioBase = salarioBase;
    }

    public void recuperarDadosPagamentoFunc()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        System.out.println("Exibindo informações do Funcionário " + this.getNome() + "...");
        System.out.println("---------------------------------------------");
        System.out.println("Nº Ingressos vendidos pelo Func: " + this.getNumVendasIngressos());
        // System.out.println("Nº Ingressos vendidos do Cinema inteiro: " + Funcionario.getNumVendasCinema());
        String string = nf.format(this.getTotalVendido());
        System.out.println("Total Vendido pelo Func: " + string);

        String string2 = nf.format(this.getTotalComissao());
        System.out.println("Total de Comissão do Func: " + string2);
        System.out.println("---------------------------------------------");
        /*
        System.out.println("---------------------------------------------");
        String string3 = nf.format(Funcionario.getTotalArrecadadoCinema());
        System.out.println("Total Arrecadado pelo Cinema: " + string3);
        System.out.println("---------------------------------------------");
        */
    }
    public static void main(String[] args) {
        
    }

}