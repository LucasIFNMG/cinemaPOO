class Ingresso
{
    // No caso de Meia-entrada ou Reserva, deve-se pedir os dados do cliente
    private Sessao sessao;
    private boolean isMeiaEntrada;
    private Funcionario funcionario;
    private Cliente cliente;
    private float preco;
    private String codigoRetirada;

    public Ingresso(Sessao sessao, boolean isMeiaEntrada, Funcionario funcionario)
    {
        this.sessao = sessao;
        this.isMeiaEntrada = isMeiaEntrada;
        this.funcionario = funcionario;
        this.preco = sessao.getPreco();
        // this.cliente = cliente;
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

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @return the codigoRetirada
     */
    public String getCodigoRetirada() {
        return codigoRetirada;
    }

    /**
     * @param codigoRetirada the codigoRetirada to set
     */
    public void setCodigoRetirada(String codigoRetirada) {
        this.codigoRetirada = codigoRetirada;
    }

    public boolean vender(int quantidade)
    {
        if(this.sessao.reservarAssentos(quantidade) == true)
        {
            this.funcionario.setTotalVendas(this.funcionario.getTotalVendas()+quantidade); 
            Funcionario.setTotalVendasCinema(Funcionario.getTotalVendasCinema() + quantidade);
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
    public boolean reservarIngresso(Cliente cliente, int quantidade)
    {
        if(this.sessao.reservarAssentos(quantidade) == true)
        {

            this.setCodigoRetirada(cliente.getDocumento());
            // TODO: Adicionar a uma Lista que guarde as Reservas;
            return true;
        }
        else
        {
            return false;
        }
    }
    */

    public boolean reservarIngresso(Cliente cliente, int quantidade)
    {
        if(this.sessao.reservarAssentos(quantidade) == true)
        {
            this.setCliente(cliente);
            this.setCodigoRetirada(cliente.getDocumento());
            // TODO: Adicionar a uma Lista que guarde as Reservas;
            return true;
        }
        else
        {
            return false;
        }
    }
    public void imprimirIngresso()
    {
        this.sessao.recuperarDados();
    }

    public boolean confirmarReservaIngresso(String codigoRetirada, int quantidade)
    {
        // TODO: Comparar código de retirada com a Lista de Reservas. Se existir, imprimir o(s) ingresso(s) e registrar a venda.
        this.funcionario.setTotalVendas(this.funcionario.getTotalVendas() + quantidade); 
        Funcionario.setTotalVendasCinema(Funcionario.getTotalVendasCinema() + quantidade);
        this.imprimirIngresso();
        return true;
    }
    
    public static void main(String[] args) {
        
    }

}