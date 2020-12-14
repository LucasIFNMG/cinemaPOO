package br.edu.ifnmg.cinema.entidade;

public class ClienteRegistrado extends Cliente{

    private static int totalClientes = 20;
    private int id;
    private String senha;
    private String cartaoCredito;
    private String documento;
    private String email;

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

    /*
    public boolean login(){
        // Autenticar Cliente
        // Ler os dados a partir do teclado
        Scanner scanner = new Scanner(System.in);

        boolean loginSucesso = false;

        ClienteRegistrado clientePesquisado = null;

        System.out.println("\nDigite o email:");
        //String emailPesquisado = "1";
        String emailPesquisado = scanner.next();

        System.out.println("Digite a senha:");
        //String senhaPesquisada = "6838";
        String senhaPesquisada = scanner.next();

        // Pesquisa no HashMap de Clientes pelo email pesquisado.
        if ((mapaClientes.get(emailPesquisado) != null)) {
            clientePesquisado = (ClienteRegistrado) mapaclientes.get(emailPesquisado);

            boolean autenticadoSucesso =
                    clientePesquisado.autenticar(senhaPesquisada);

            if(autenticadoSucesso){
                System.out.printf("%s (%s) autenticado com sucesso!",
                        clientePesquisado.getNome(),
                        clientePesquisado.getId());
            }else{
                System.out.printf("%s (%s) não autenticado! Senha incorreta",
                        clientePesquisado.getNome(),
                        clientePesquisado.getId());
            }
        }else {
            System.out.println("cliente não encontrada!");

        }
        return loginSucesso;

    }
*/

    // TODO
    /*
    public String reservarSessao(Sessao sessao, int quantidade, int numeroAssento){
        // Em caso de sucesso, retornar o id do ingresso
        // Ingresso novoIngresso = new Ingresso();
        // return novoIngresso.getId();
    }
    */
}
