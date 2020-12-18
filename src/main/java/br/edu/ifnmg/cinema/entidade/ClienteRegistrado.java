package br.edu.ifnmg.cinema.entidade;

public class ClienteRegistrado extends Cliente{

    private static int totalClientes = 20;
    private final int id;
    private final String senha;
    private String cartaoCredito;
    private final String documento;
    private final String email;

    public ClienteRegistrado(int id, String nome,String senha, String email, String documento, int idade) {
        super(nome, documento, idade);
        ClienteRegistrado.totalClientes++;
        this.id = totalClientes;
        this.idade = idade;
        this.senha = senha;
        this.email = email;
        this.documento = documento;
    }

    public ClienteRegistrado(String nome,String senha, String email, String documento, int idade) {
        super(nome, documento, idade);
        ClienteRegistrado.totalClientes++;
        this.id = totalClientes;
        this.idade = idade;
        this.senha = senha;
        this.email = email;
        this.documento = documento;
    }

    public String getSenha() { return this.senha;}

    public boolean autenticar(String senha) {
        return this.getSenha().equals(senha);
    }

    public String getDocumento() {
        return documento;
    }

}
