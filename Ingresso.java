class Ingresso
{

    // No caso de Meia-entrada ou Reserva, deve-se pedir os dados do cliente
    private Sessao sessao;
    private boolean isMeiaEntrada;
    private Funcionario funcionario;
    private Cliente cliente;

    public Ingresso(Sessao sessao, boolean isMeiaEntrada, Funcionario funcionario)
    {
        this.sessao = sessao;
        this.isMeiaEntrada = isMeiaEntrada;
        this.funcionario = funcionario;
    }

    /**
     * @return the sessao
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public boolean getIsMeiaEntrada()
    {
        return this.isMeiaEntrada;
    }

    public void setIsMeiaEntrada(boolean isMeiaEntrada)
    {
        this.isMeiaEntrada = isMeiaEntrada;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void main(String[] args) {
        
    }

}