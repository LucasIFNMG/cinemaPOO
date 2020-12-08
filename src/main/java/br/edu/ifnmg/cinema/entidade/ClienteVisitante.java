package br.edu.ifnmg.cinema.entidade;

public class ClienteVisitante extends Cliente{
    public ClienteVisitante(String nome, String documento, int idade) {
        super(nome, documento, idade);
    }

    public ClienteRegistrado registrar(String email, String senha){
        int id = ClienteRegistrado.getTotalClientes();
        return new ClienteRegistrado(id, nome, senha, email, documento, idade);
    }
}
