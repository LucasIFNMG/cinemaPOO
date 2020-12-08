package br.edu.ifnmg.cinema.entidade;

import java.text.NumberFormat;

public abstract class Funcionario{

    protected String nome;
    protected String id;
    protected String senha;
    protected double salarioBase;
    protected int nivelAcesso;

    protected static int numVendasCinema = 0;
    protected static double totalArrecadadoCinema;
    

    public Funcionario(String nome, String id, String senha, double salarioBase, int nivelAcesso)
    {

        /*
        if (id.parseInt <= 0)
            throw new IllegalArgumentException(
                "ID inválido!");
        */
            // compareTo: retorna -1, 0 ou 1. -1: 1º parâmetro MENOR do que o 2º. 0: 1º == 2º. 1: 1º > 2º.
        if(salarioBase == -1)
            throw new IllegalArgumentException(
                "Salário-base deve ser >= 0! ");

        this.nome = nome;
        this.id = id;
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }


    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase)
    {
        if(salarioBase == -1)
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

    public boolean autenticar(String senha) {
        return this.getSenha().equals(senha);
    }

}