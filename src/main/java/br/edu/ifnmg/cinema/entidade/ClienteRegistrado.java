package br.edu.ifnmg.cinema.entidade;

public class ClienteRegistrado extends Cliente{

    private String id;
    private String senha;
    private String cartaoCredito;
    private String email;

    public ClienteRegistrado(String nome, String documento, int idade) {
        super(nome, documento, idade);
    }

    public ClienteRegistrado() {
        super();
    }

    public boolean login(){
        // Autenticar Cliente
        boolean loginSucesso = true;
        return loginSucesso;
    }

    public String reservarSessao(Sessao sessao, int quantidade, int numeroAssento){
        // Em caso de sucesso, retornar o id do ingresso
        Ingresso novoIngresso = new Ingresso();
        return novoIngresso.getId();
    }
}
