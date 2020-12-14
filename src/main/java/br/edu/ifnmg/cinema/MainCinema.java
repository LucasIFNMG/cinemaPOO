package br.edu.ifnmg.cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.edu.ifnmg.cinema.entidade.*;

public class MainCinema{
    
    private static final HashMap <String, Funcionario> mapaFuncionarios = new HashMap<>();
    private static final HashMap <String, Reserva> mapaReservas = new HashMap<>();
    private static final HashMap <String, ClienteRegistrado> mapaClientes = new HashMap<>();
    private static final HashMap <Integer, Filme> mapaFilmes = new HashMap<>();
    private static final HashMap <Integer, Sessao> mapaSessoes = new HashMap<>();
    private static final HashMap <Integer, SalaCinema> mapaSalasCinema = new HashMap<>();

    public static void main(String[] args) throws IOException {

        carregarDados();
        exibirMenus();
    }

    private static void exibirMenus() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("Você é um Cliente ou Funcionário?");
        System.out.println("1: Funcionário");
        System.out.println("2: Cliente");
        System.out.println("3: Cliente Visitante - Desejo me cadastrar");

        int opcaoUsuario = Integer.parseInt(scanner.nextLine());

        // Menu Funcionário
        if (opcaoUsuario == 1)
        {
            Funcionario funcionario = autenticarFuncionario();
            int operacao;

            // Menu ADMIN (nivelAcesso = ESPECIAL)

            if (funcionario instanceof Administrador) {

                do {
                    System.out.println("MENU ADMIN");
                    System.out.println("Digite uma opção:");
                    //System.out.println("1: Vender Ingresso");
                    System.out.println("2: Imprimir Ingresso");
                    System.out.println("3: Consultar Reserva");
                    System.out.println("4: Criar Sessão");
                    System.out.println("5: Editar Sessão");
                    System.out.println("6: Cadastrar Filme");
                    System.out.println("7: Consultar Total de Vendas");
                    System.out.println("8: Consultar Salário de Funcionários:");
                    System.out.println("9: Sair");
                    System.out.println("Digite uma opção:");

                    operacao = Integer.parseInt(scanner.nextLine());

                    switch (operacao) {
                        case 1:
                            venderIngresso((Vendedor) funcionario);
                            break;

                    }

                } while (operacao != 9);
            }

            if (funcionario instanceof Vendedor){

                do {
                    // Menu VENDEDOR (nivelAcesso = PADRAO)
                    System.out.println("MENU VENDEDOR");
                    System.out.println("Digite uma opção:");
                    System.out.println("1: Vender Ingresso");
                    System.out.println("2: Imprimir Ingresso");
                    System.out.println("3: Consultar Reserva");
                    System.out.println("4: Sair");

                    operacao = Integer.parseInt(scanner.nextLine());

                    switch(operacao){
                        case 1:
                            venderIngresso( (Vendedor) funcionario);
                    }

                } while (operacao != 4);
            }

        }

        // Menu Cliente Registrado
        if (opcaoUsuario == 2){
            ClienteRegistrado clienteRegistrado = loginCliente();
            int operacao;

            do {
                System.out.println("MENU CLIENTE");
                System.out.println("Digite uma opção:");
                System.out.println("1: Visualizar Sessões");
                System.out.println("2: Reservar Sessão");
                System.out.println("3: Sair");

                operacao = Integer.parseInt(scanner.nextLine());

            } while (operacao != 3);
        }

        // Cadastrar Cliente
        if (opcaoUsuario == 3){
            System.out.println("Digite o seu nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o seu e-mail: ");
            String email = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
            System.out.println("Digite o seu CPF: ");
            String documento = scanner.nextLine();
            //System.out.println("Digite o ano em que você nasceu: ");
            System.out.println("Digite a sua idade:");
            int idade = scanner.nextInt();
            ClienteVisitante.registrar(nome, senha, email, documento, idade, mapaClientes);
            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println("Faça o log-in utilizando o seu e-mail e senha.");
            exibirMenus();
        }
    }

    private static void venderIngresso(Vendedor vendedor) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a sessão:");
        for (Map.Entry<Integer, Sessao> entry : mapaSessoes.entrySet()) {
                entry.getValue().imprimirFilmeHorarioSessao();
        }

        int opcaoSessao = Integer.parseInt(scanner.nextLine());
        Sessao sessaoEscolhida = mapaSessoes.get(opcaoSessao);
        SalaCinema salaSessaoEscolhida = sessaoEscolhida.getSala();

        int opcaoAssento;
        int opcaoEntrada;

        if (salaSessaoEscolhida.isSalaLotada()){
            System.out.println("Sessão lotada!");
        }else{
            System.out.println("Escolha o nº do assento:");
            salaSessaoEscolhida.imprimirAssentosDisponiveis();
            // TODO: EXCEPTION EM OPCAO
            opcaoAssento = Integer.parseInt(scanner.nextLine());
            salaSessaoEscolhida.reservarAssento(opcaoAssento);
            System.out.println("Assento Reservado.");

            System.out.println("Meia Entrada ou Inteira?");
            System.out.println("1 - Meia Entrada");
            System.out.println("2 - Inteira");
            // TODO: EXCEPTION EM OPCAO
            opcaoEntrada = Integer.parseInt(scanner.nextLine());

            if (opcaoEntrada == 1){
                System.out.println("Conferir documento!");
                Ingresso ingresso = new Ingresso(sessaoEscolhida, true, opcaoAssento);
                Venda venda = new Venda(ingresso, vendedor);
            } else {
                Ingresso ingresso = new Ingresso(sessaoEscolhida, false, opcaoAssento);
                Venda venda = new Venda(ingresso, vendedor);
            }

            System.out.printf("Preço = R$ %.2f%n", sessaoEscolhida.getPreco());
            System.out.println("Venda realizada com sucesso!");
        }

    }


    private static void carregarDados() throws IOException {
        carregarDadosClientesRegistrados();
        carregarDadosFuncionarios();
        carregarDadosFilmes();
        carregarDadosSalas();
        carregarDadosSessoes();
    }

    private static void carregarDadosClientesRegistrados() throws IOException {
        System.out.println("Carregando dados de clientes...");

        String arquivo = "dados/clientes.csv";
        BufferedReader bufferedReader = null;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            int id = Integer.parseInt(colunas[0]);
            String nome = colunas[1];
            String senha = colunas[2];
            String email = colunas[3];
            String documento = colunas[4];
            int idade = Integer.parseInt(colunas[5]);
            ClienteRegistrado cliente = new ClienteRegistrado(id, nome, senha, email, documento, idade);
            mapaClientes.put(email, cliente);
        }
        System.out.println("Dados de clientes pessoa física carregados.");
    }

    private static void carregarDadosFuncionarios() throws IOException {
        System.out.println("Carregando dados de funcionários...");

        String arquivo = "dados/funcionarios.csv";
        BufferedReader bufferedReader = null;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            String id = colunas[0];
            String nome = colunas[1];
            String senha = colunas[2];
            int nivelAcesso = Integer.parseInt(colunas[3]);
            double salarioBase = Double.parseDouble(colunas[4]);
            if (nivelAcesso == 0) {
                Funcionario vendedor = new Vendedor(id, nome, senha, salarioBase, nivelAcesso);
                mapaFuncionarios.put(id, vendedor);
            } else{
                Funcionario administrador = new Administrador(id, nome, senha, salarioBase, nivelAcesso);
                mapaFuncionarios.put(id, administrador);
            }
        }
        System.out.println("Dados de funcionários.");
    }

    private static void carregarDadosFilmes() throws IOException {
        System.out.println("Carregando dados de filmes...");

        String arquivo = "dados/movies.csv";
        BufferedReader bufferedReader = null;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            int id = Integer.parseInt(colunas[0]);
            String nome = colunas[1];
            String genero = colunas[2];
            int duracaoMins = Integer.parseInt(colunas[3]);
            String censura = colunas[4];
            String diretor = colunas[5];
            Filme filme = new Filme(id, nome, genero, duracaoMins, censura, diretor);
            mapaFilmes.put(id, filme);
        }
        System.out.println("Dados de Filmes carregados.");
    }

    private static void carregarDadosSessoes() throws IOException {
        System.out.println("Carregando dados de sessoes...");

        String arquivo = "dados/sessoes.csv";
        BufferedReader bufferedReader = null;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            int idSessao = Integer.parseInt(colunas[0]);
            int idFilme = Integer.parseInt(colunas[1]);
            String exibicao = colunas[2];
            String dimensao = colunas[3];
            int dia = Integer.parseInt(colunas[4]);
            String horario = colunas[5];
            int numeroSala = Integer.parseInt(colunas[6]);

            Filme filme = mapaFilmes.get(idFilme);
            SalaCinema salaCinema = mapaSalasCinema.get(numeroSala);

            Sessao sessao = new Sessao(idSessao, filme, exibicao, dimensao, salaCinema, dia, horario);
            mapaSessoes.put(idSessao, sessao);
        }
        System.out.println("Dados das sessões carregados.");
    }

    private static void carregarDadosSalas() throws IOException {
        System.out.println("Carregando dados das salas...");

        String arquivo = "dados/salasCinema.csv";
        BufferedReader bufferedReader = null;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            int numeroSala = Integer.parseInt(colunas[0]);
            int capacidadeAssentos = Integer.parseInt(colunas[1]);

            SalaCinema salaCinema = new SalaCinema(numeroSala, capacidadeAssentos);
            mapaSalasCinema.put(numeroSala, salaCinema);
        }
        System.out.println("Dados das salas carregados.");
    }

    private static Funcionario autenticarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        Funcionario funcionarioPesquisado = null;

        do{
            System.out.println("\nDigite o ID do funcionario:");
            //String numeroPesquisado = "1";
            String idPesquisado = scanner.nextLine();

            System.out.println("Digite a senha:");
            //String senhaPesquisada = "6838";
            String senhaPesquisada = scanner.nextLine();

            // Pesquisa no HashMap de Funcionários pelo ID pesquisado.
            if ((mapaFuncionarios.get(idPesquisado) != null)) {
                funcionarioPesquisado = mapaFuncionarios.get(idPesquisado);

                boolean autenticadoSucesso =
                        funcionarioPesquisado.autenticar(senhaPesquisada);

                if(autenticadoSucesso){
                    System.out.printf("%s (%s) autenticado com sucesso!",
                            funcionarioPesquisado.getNome(),
                            funcionarioPesquisado.getId());
                }else{
                    System.out.printf("%s (%s) não autenticado! Senha incorreta",
                            funcionarioPesquisado.getNome(),
                            funcionarioPesquisado.getId());
                }
            }else {
                System.out.println("Funcionário não encontrado!");
            }
        }while (funcionarioPesquisado == null);

        return funcionarioPesquisado;
    }

    public static ClienteRegistrado loginCliente(){

        Scanner scanner = new Scanner(System.in);

        boolean loginSucesso = false;

        ClienteRegistrado clientePesquisado = null;

        System.out.println("\nDigite o email:");
        //String emailPesquisado = "1";
        String emailPesquisado = scanner.nextLine();

        System.out.println("Digite a senha:");
        //String senhaPesquisada = "6838";
        String senhaPesquisada = scanner.nextLine();

        // Pesquisa no HashMap de Clientes pelo email pesquisado.
        if ((mapaClientes.get(emailPesquisado) != null)) {
            clientePesquisado = mapaClientes.get(emailPesquisado);

            boolean autenticadoSucesso =
                    clientePesquisado.autenticar(senhaPesquisada);

            if(autenticadoSucesso){
                System.out.printf("%s autenticado com sucesso!",
                        clientePesquisado.getNome());

            }else{
                System.out.printf("Cliente não autenticado! Senha incorreta!%n");
                return null;
            }
        }else {
            System.out.println("Cliente não encontrado!");

        }
        return clientePesquisado;

    }

    public Reserva consultarReserva(String codigoReserva){
        //TODO: Validar
        return mapaReservas.get(codigoReserva);
    }
}



