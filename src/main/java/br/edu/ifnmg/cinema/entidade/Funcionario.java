package br.edu.ifnmg.cinema.entidade;

import java.text.NumberFormat;

public abstract class Funcionario{

    protected String nome;
    protected String id;
    protected String senha;
    protected double salarioBase;
    protected int nivelAcesso;

    public Funcionario(String nome, String id, String senha, double salarioBase, int nivelAcesso)
    {

        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.salarioBase = salarioBase;
        this.nivelAcesso = 0;

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