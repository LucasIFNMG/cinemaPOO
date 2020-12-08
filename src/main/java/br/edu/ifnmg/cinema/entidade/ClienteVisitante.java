package br.edu.ifnmg.cinema.entidade;

import java.util.HashMap;

public class ClienteVisitante extends Cliente{
    public ClienteVisitante(String nome, String documento, int idade) {
        super(nome, documento, idade);
    }

    public static void registrar(String nome, String senha, String email, String documento, int idade, HashMap<String, ClienteRegistrado> mapaClientes){
        ClienteRegistrado novoCliente = new ClienteRegistrado(nome, senha, email, documento, idade);
        mapaClientes.put(email, novoCliente);
    }
}
