package br.edu.ifnmg.cinema.entidade;

public class ClienteVisitante extends Cliente{
    public ClienteVisitante(String nome, String documento, int idade) {
        super(nome, documento, idade);
    }

    public boolean registrar(){
        //TODO Solicitar email, Senha
        ClienteRegistrado novoClienteRegistrado = new ClienteRegistrado();
        System.out.println("Cliente cadastrado com sucesso!");
        boolean registrouSucesso = true;
        if (!registrouSucesso) {
            registrouSucesso = false;
        }
        return registrouSucesso;
    }
}
