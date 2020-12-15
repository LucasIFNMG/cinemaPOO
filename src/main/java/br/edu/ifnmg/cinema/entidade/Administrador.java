package br.edu.ifnmg.cinema.entidade;

import java.text.NumberFormat;

public class Administrador extends Funcionario{

    public Administrador(String nome, String id, String senha, double salarioBase, int nivelAcesso) {
        super(nome, id, senha, salarioBase, nivelAcesso);
    }

    public void recuperarDadosPagamentoFunc()
    {

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
}
