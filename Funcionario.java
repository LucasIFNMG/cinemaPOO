class Funcionario
{
    private String nome;
    private int id;
    private String cpf;
    private int nivelAcesso;    //0: Apenas Vendas.  1(Gerente): Editar Sessões
    private int totalVendas = 0;
    private static int totalVendasCinema = 0;

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
    public int getTotalVendas() {
        return totalVendas;
    }

    /**
     * @param totalVendas the totalVendas to set
     */
    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }

    /**
     * @return the totalVendasCinema
     */
    public static int getTotalVendasCinema() {
        return Funcionario.totalVendasCinema;
    }

    /**
     * @param totalVendasCinema the totalVendasCinema to set
     */
    public static void setTotalVendasCinema(int totalVendasCinema) {
        Funcionario.totalVendasCinema = totalVendasCinema;
    }

    public static void main(String[] args) {
        
    }

}