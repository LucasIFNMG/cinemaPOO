package br.edu.ifnmg.cinema.entidade;

public class Ingresso
{
    // No caso de Meia-entrada ou Reserva, deve-se pedir os dados do cliente
    private Sessao sessao;
    private boolean isMeiaEntrada;
    private Funcionario funcionario;
    private Cliente cliente;
    private double preco;
    private String id;
    private int numeroAssento;

    public Ingresso(Sessao sessao, boolean isMeiaEntrada, Funcionario funcionario, Cliente cliente, int numeroAssento)
    {
        this.sessao = sessao;
        this.isMeiaEntrada = isMeiaEntrada;
        this.funcionario = funcionario;
        this.preco = sessao.getPreco();
        this.cliente = cliente;
        this.numeroAssento = numeroAssento;
    }

    public Ingresso() {

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
    public double getPreco() {
        return preco;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;

    }

    /*


    public boolean reservarIngresso(Cliente cliente, int quantidade)
    {
        if(this.sessao.reservarAssentos(quantidade) == true)
        {
            this.setCliente(cliente);
            this.setCodigoRetirada(cliente.getDocumento());
            // TODO: Adicionar a uma Lista que guarde as Reservas;
            System.out.println("Ingresso(s) reservado(s) com sucesso!");
            return true;
        }
        else
        {
            System.out.println("NÃO foi possível reservar o(s) ingresso(s)!");
            return false;
        }
    }
    public void imprimirIngresso()
    {
        System.out.println("Ingresso #" + this.getId());
        this.sessao.recuperarDadosSessao();
    }

    public boolean confirmarReservaIngresso(String codigoRetirada, int quantidade)
    {
        // TODO: Comparar código de retirada com a Lista de Reservas. Se existir, imprimir o(s) ingresso(s) e registrar a venda.
        
        // Incrementa o nº de Vendas do Funcionário e o nº de Vendas do Cinema
        this.funcionario.setNumVendasIngressos(this.funcionario.getNumVendasIngressos() + quantidade); 
        Funcionario.setNumVendasCinema(Funcionario.getNumVendasCinema() + quantidade);

        // Incrementa o valor($) arrecadado pelo Funcionário e pelo Cinema
        double valorVenda = this.getPreco().multiply(double.valueOf(quantidade));
        if(this.funcionario.getTotalVendido() != null)
        {
            valorVenda = valorVenda.add(this.funcionario.getTotalVendido());
            this.funcionario.setTotalVendido(valorVenda);
        }
        else
        {
            this.funcionario.setTotalVendido(valorVenda);
        }

        if(Funcionario.getTotalArrecadadoCinema() != null)
        {
            valorVenda = valorVenda.add(Funcionario.getTotalArrecadadoCinema());
            Funcionario.setTotalArrecadadoCinema(valorVenda);
        }
        else
        {
            Funcionario.setTotalArrecadadoCinema(valorVenda);
        }
        
        this.imprimirIngresso();
        return true;

     */
}