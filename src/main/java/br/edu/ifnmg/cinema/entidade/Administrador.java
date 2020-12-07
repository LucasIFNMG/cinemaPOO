package br.edu.ifnmg.cinema.entidade;

import java.math.BigDecimal;

public class Administrador extends Funcionario{
    public Administrador(String nome, String id, String cpf, BigDecimal salarioBase) {
        super(nome, id, cpf, salarioBase);
    }
}
