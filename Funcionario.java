import java.math.BigDecimal;
import java.text.NumberFormat;

class Funcionario
{
    private String nome;
    private int id;
    private String cpf;
    private int nivelAcesso;    //0: Apenas Vendas.  1(Gerente): Editar Sessões, Gerar relatórios
    private int numVendasIngressos = 0;
    private BigDecimal totalVendido;
    private BigDecimal comissao;
    private static int numVendasCinema = 0;
    private static BigDecimal totalArrecadadoCinema;
    

    public Funcionario(String nome, int id, String cpf)
    {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.nivelAcesso = 0;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nivelAcesso
     */
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    /**
     * @param nivelAcesso the nivelAcesso to set
     */
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    /**
     * @return the totalVendas
     */
    public int getNumVendasIngressos() {
        return numVendasIngressos;
    }

    /**
     * @param totalVendas the totalVendas to set
     */
    public void setNumVendasIngressos(int numVendasIngressos) {
        this.numVendasIngressos = numVendasIngressos;
    }

    /**
     * @return the totalVendido
     */
    public BigDecimal getTotalVendido() {
        return this.totalVendido;
    }

    /**
     * @param totalVendido the totalVendido to set
     */
    public void setTotalVendido(BigDecimal totalVendido) {
        this.totalVendido = totalVendido;
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
    public BigDecimal getComissao() {
        // totalVendido = this.getTotalVendido();
        BigDecimal percent10 = new BigDecimal("0.1");  
        this.comissao = this.getTotalVendido().multiply(percent10);
        return this.comissao;
    }

    /**
     * @return the totalArrecadadoCinema
     */
    public static BigDecimal getTotalArrecadadoCinema() {
        return Funcionario.totalArrecadadoCinema;
    }

    /**
     * @param totalArrecadadoCinema the totalArrecadadoCinema to set
     */
    public static void setTotalArrecadadoCinema(BigDecimal totalArrecadadoCinema) {
        Funcionario.totalArrecadadoCinema = totalArrecadadoCinema;
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

        String string2 = nf.format(this.getComissao());
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