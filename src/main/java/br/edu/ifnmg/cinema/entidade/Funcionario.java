package br.edu.ifnmg.cinema.entidade;

import java.math.BigDecimal;
import java.text.NumberFormat;

public abstract class Funcionario{

    protected String nome;
    protected String id;
    protected String cpf;
    protected String senha;
    protected BigDecimal salarioBase;

    protected static int numVendasCinema = 0;
    protected static BigDecimal totalArrecadadoCinema;
    

    public Funcionario(String nome, String id, String cpf, BigDecimal salarioBase)
    {

        /*
        if (id.parseInt <= 0)
            throw new IllegalArgumentException(
                "ID inválido!");
        */
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
    public String getId() {
        return id;
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
        //System.out.println("Nº Ingressos vendidos pelo Func: " + this.getNumVendasIngressos());
        // System.out.println("Nº Ingressos vendidos do Cinema inteiro: " + Funcionario.getNumVendasCinema());
        //String string = nf.format(this.getTotalVendido());
        //System.out.println("Total Vendido pelo Func: " + string);

        //String string2 = nf.format(this.getTotalComissao());
        //System.out.println("Total de Comissão do Func: " + string2);
        System.out.println("---------------------------------------------");
        /*
        System.out.println("---------------------------------------------");
        String string3 = nf.format(Funcionario.getTotalArrecadadoCinema());
        System.out.println("Total Arrecadado pelo Cinema: " + string3);
        System.out.println("---------------------------------------------");
        */
    }

    public boolean autenticar(String senhaPesquisada) {
        // TODO Verificar Senha
        return true;
    }


    /*
    public boolean venderIngresso(Sessao sessao, int quantidade, int numeroAssento)
    {
        if(this.sessao.reservarAssentos(quantidade) == true)
        {
            // Incrementa o nº de Vendas do Funcionário e o nº de Vendas do Cinema
            this.funcionario.setNumVendasIngressos(this.funcionario.getNumVendasIngressos() + quantidade);
            Funcionario.setNumVendasCinema(Funcionario.getNumVendasCinema() + quantidade);

            // Incrementa o valor($) arrecadado pelo Funcionário e pelo Cinema
            BigDecimal valorVenda = this.getPreco().multiply(BigDecimal.valueOf(quantidade));
            this.funcionario.setTotalVendido(valorVenda.add(this.funcionario.getTotalVendido()));
            Funcionario.setTotalArrecadadoCinema(valorVenda.add(Funcionario.getTotalArrecadadoCinema()));
            System.out.println("Ingresso(s) reservado(s) com sucesso!");
            return true;
        }
        else
        {
            System.out.println("NÃO foi possível reservar o(s) ingresso(s)!");
            return false;
        }
    }

     */

}