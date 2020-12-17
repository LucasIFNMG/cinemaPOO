package br.edu.ifnmg.cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import br.edu.ifnmg.cinema.entidade.*;

public class MainCinema{

    private static final int SEGUNDA_FEIRA = 1;
    private static final int TERCA_FEIRA = 2;
    private static final int QUARTA_FEIRA = 3;
    private static final int QUINTA_FEIRA = 4;
    private static final int SEXTA_FEIRA = 5;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;
    
    private static final HashMap <String, Funcionario> mapaFuncionarios = new HashMap<>();
    private static final HashMap <Integer, Reserva> mapaReservas = new HashMap<>();
    private static final HashMap <String, ClienteRegistrado> mapaClientes = new HashMap<>();
    private static final HashMap <Integer, Filme> mapaFilmes = new HashMap<>();
    private static final HashMap <Integer, Sessao> mapaSessoes = new HashMap<>();
    private static final HashMap <Integer, SalaCinema> mapaSalasCinema = new HashMap<>();
    private static final HashMap <Integer, Venda> mapaVendas = new HashMap<>();

    public static void main(String[] args) throws IOException {

        carregarDados();
        exibirMenus();
    }

    private static void exibirMenus() {

        Scanner scanner = new Scanner(System.in);
        int opcaoUsuario;

        do {

            System.out.println("*************************************");
            System.out.println("Você é um Cliente ou Funcionário?");
            System.out.println("1: Funcionário");
            System.out.println("2: Cliente");
            System.out.println("3: Cliente Visitante - Desejo me cadastrar");
            System.out.println("0: Encerrar Programa");

            opcaoUsuario = Integer.parseInt(scanner.nextLine());

            // Menu Funcionário
            if (opcaoUsuario == 1) {
                Funcionario funcionario = autenticarFuncionario();
                int operacao;

                // Menu ADMIN (nivelAcesso = ESPECIAL)

                if (funcionario instanceof Administrador) {

                    do {
                        System.out.println("MENU ADMIN");
                        System.out.println("Digite uma opção:");
                        System.out.println("1: Criar Sessão");
                        System.out.println("2: Editar Sessão");
                        System.out.println("3: Cadastrar Filme");
                        System.out.println("4: Consultar Total de Vendas");
                        System.out.println("5: Consultar Salário de Funcionários:");
                        System.out.println("6: Log out");
                        System.out.println("Digite uma opção:");

                        operacao = Integer.parseInt(scanner.nextLine());

                        switch (operacao) {
                            case 1:
                                cadastrarSessao();
                                break;
                            case 2:
                                editarSessao();
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                System.out.println("Saindo...");
                                break;

                        }

                    } while (operacao != 6);
                }

                if (funcionario instanceof Vendedor) {

                    do {
                        // Menu VENDEDOR (nivelAcesso = PADRAO)
                        System.out.println("MENU VENDEDOR");
                        System.out.println("Digite uma opção:");
                        System.out.println("1: Vender Ingresso");
                        System.out.println("2: Consultar Reserva");
                        System.out.println("3: Log out");

                        operacao = Integer.parseInt(scanner.nextLine());

                        switch (operacao) {
                            case 1:
                                venderIngresso((Vendedor) funcionario);
                                break;
                            case 2:
                                consultarReserva();
                                break;
                            case 3:
                                System.out.println("Saindo...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;

                        }

                    } while (operacao != 3);
                }

            }

            // Menu Cliente Registrado
            if (opcaoUsuario == 2) {
                ClienteRegistrado clienteRegistrado = loginCliente();
                int operacao;

                do {
                    System.out.println("MENU CLIENTE");
                    System.out.println("Digite uma opção:");
                    System.out.println("1: Visualizar Sessões");
                    System.out.println("2: Reservar Sessão");
                    System.out.println("3: Log out");

                    operacao = Integer.parseInt(scanner.nextLine());

                    switch (operacao) {
                        case 1:
                            assert clienteRegistrado != null;
                            visualizarSessoes();
                            break;
                        case 2:
                            reservarSessao(clienteRegistrado);
                            break;
                        case 3:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;

                    }

                } while (operacao != 3);
            }

            // Cadastrar Cliente
            if (opcaoUsuario == 3) {
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
        } while (opcaoUsuario != 0);

        System.out.println("Encerrando...");
    }

    private static void editarSessao() {

        Scanner scanner = new Scanner(System.in);
        int numeroSessao;

        boolean sessaoValida = true;
        do {
            try {
                for (Map.Entry<Integer, Sessao> entry : mapaSessoes.entrySet()) {
                    System.out.printf("%d - ", entry.getKey());
                    entry.getValue().imprimirFilmeDiaHorarioSessao();
                    System.out.println();
                }
                System.out.println("Informe o nº da Sessão a ser editada: ");
                numeroSessao = Integer.parseInt(scanner.nextLine());

                Sessao sessaoRemovida = mapaSessoes.remove(numeroSessao);
                Objects.requireNonNull(sessaoRemovida);

            } catch (NullPointerException e) {
                sessaoValida = false;
                System.out.println("Sessão inválida!");
            }
        } while (!sessaoValida);
        cadastrarSessao();
    }

    private static void cadastrarSessao() {
        Scanner scanner = new Scanner(System.in);

        // Exibir Filmes
        for (Map.Entry<Integer, Filme> entry : mapaFilmes.entrySet()) {
            System.out.printf("%d - %s%n", entry.getKey(), entry.getValue().getNome());
        }

        System.out.println("Informe o nº do Filme:");
        int numeroFilmeEscolhido = Integer.parseInt(scanner.nextLine());
        Filme filmeSessao = mapaFilmes.get(numeroFilmeEscolhido);

        System.out.println("Dublado ou Legendado?");
        String exibicaoFilme = scanner.nextLine();

        System.out.println("2D ou 3D?");
        String dimensaoFilme = scanner.nextLine();

        // Exibir Salas
        for (Map.Entry<Integer, SalaCinema> entry : mapaSalasCinema.entrySet()) {
            System.out.printf("%d ", entry.getKey());
        }
        System.out.println();
        System.out.println("Informe o nº da Sala em que a sessão será exibida :");
        int numeroSala = Integer.parseInt(scanner.nextLine());
        SalaCinema salaSessao = mapaSalasCinema.get(numeroSala);

        System.out.println("1 - Segunda-Feira");
        System.out.println("2 - Terça-Feira");
        System.out.println("3 - Quarta-Feira");
        System.out.println("4 - Quinta-Feira");
        System.out.println("5 - Sexta-Feira");
        System.out.println("6 - Sábado");
        System.out.println("7 - Domingo");
        System.out.println("Informe o Dia em que a sessão será exibida:");
        int diaSessao = Integer.parseInt(scanner.nextLine());
        diaSessao = converterNumeroDiaParaNome(diaSessao);

        System.out.println("Informe o Horário da sessão (HH:MM): ");
        String horarioSessao = scanner.nextLine();

        Sessao novaSessao = new Sessao(filmeSessao, exibicaoFilme, dimensaoFilme, salaSessao, diaSessao, horarioSessao);
        // TODO: Teste unitário
        mapaSessoes.put(novaSessao.getId(), novaSessao);
        System.out.println("Sessão cadastrada com sucesso!");
    }

    private static int converterNumeroDiaParaNome(int diaSessao) {

        switch(diaSessao){
            case 1:
                return SEGUNDA_FEIRA;
            case 2:
                return TERCA_FEIRA;
            case 3:
                return QUARTA_FEIRA;
            case 4:
                return QUINTA_FEIRA;
            case 5:
                return SEXTA_FEIRA;
            case 6:
                return SABADO;
            case 7:
                return DOMINGO;
        }

        return diaSessao;
    }

    private static void visualizarSessoes() {
        for (Map.Entry<Integer, Sessao> entry : mapaSessoes.entrySet()) {
            entry.getValue().imprimirFilmeDiaHorarioSessao();
        }
    }

    private static void reservarSessao(ClienteRegistrado clienteRegistrado) {
        // TODO: Reserva Herdar de Venda
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer, Sessao> entry : mapaSessoes.entrySet()) {
            System.out.printf("%d - ", entry.getKey());
            entry.getValue().imprimirFilmeDiaHorarioSessao();
        }
        System.out.println("Informe a sessão:");
        int opcaoSessao = Integer.parseInt(scanner.nextLine());
        Sessao sessaoEscolhida = mapaSessoes.get(opcaoSessao);
        SalaCinema salaSessaoEscolhida = sessaoEscolhida.getSala();

        int opcaoAssento;
        int opcaoEntrada;

        if (salaSessaoEscolhida.isSalaLotada()){
            System.out.println("Sessão lotada!");
        }else{

            boolean reservouSucesso;
            do {
                System.out.println("Escolha o nº do assento:");
                salaSessaoEscolhida.imprimirAssentosDisponiveis();
                // TODO: EXCEPTION EM OPCAO
                opcaoAssento = Integer.parseInt(scanner.nextLine()) - 1;

                 reservouSucesso = salaSessaoEscolhida.reservarAssento(opcaoAssento);

                 if (!reservouSucesso){
                     System.out.println("ERRO! Este assento já está reservado!");
                 }
            } while(!reservouSucesso);

            System.out.println("Meia Entrada ou Inteira?");
            System.out.println("1 - Meia Entrada");
            System.out.println("2 - Inteira");
            // TODO: EXCEPTION EM OPCAO
            opcaoEntrada = Integer.parseInt(scanner.nextLine());

            if (opcaoEntrada == 1){
                System.out.printf("Atenção: o direito da meia-entrada é intransferível.%n" +
                        "Você deve apresentar o seu documento quando for imprimir o seu ingresso.%n");
                Ingresso ingresso = new Ingresso(sessaoEscolhida, true, opcaoAssento);
                Reserva reserva = new Reserva(ingresso, clienteRegistrado);
                mapaReservas.put(reserva.getId(), reserva);
                System.out.printf("Código da Reserva: %s%n", reserva.getCodigoReserva());
                System.out.printf("Preço = R$ %.2f%n", ingresso.getPreco());

            } else {
                Ingresso ingresso = new Ingresso(sessaoEscolhida, false, opcaoAssento);
                Reserva reserva = new Reserva(ingresso, clienteRegistrado);
                mapaReservas.put(reserva.getId(), reserva);
                System.out.printf("Código da Reserva: %s%n", reserva.getCodigoReserva());
                System.out.printf("Preço = R$ %.2f%n", ingresso.getPreco());

            }

            /* TODO: debitarCartão
            System.out.println("Informe o nº do cartão de crédito:");
            String numeroCartao = scanner.nextLine();
            System.out.println("Informe o CVC: ");
            String cvcCartao = scanner.nextLine();
            */

            System.out.println("Reserva realizada com sucesso!");
            System.out.println("Apresente o Código da Reserva junto com o seu documento para imprimir o ingresso.");
        }
    }

    private static void consultarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID da reserva:");
        int idReserva = Integer.parseInt(scanner.nextLine());
        // TODO: Exception na busca
        Reserva reservaPesquisada = mapaReservas.get(idReserva);
        int idSessaoReservada = reservaPesquisada.getIngresso().getSessao().getId();
        String filmeSessaoReservada = reservaPesquisada.getIngresso().getSessao().getFilme().getNome();
        String nomeClienteReservou = reservaPesquisada.getClienteRegistrado().getNome();
        String documentoClienteReservou = reservaPesquisada.getClienteRegistrado().getDocumento();

        System.out.printf("Sessão: %d" + "Filme: %s" + "Cliente: %s" + "Documento: %s",
                idSessaoReservada, filmeSessaoReservada, nomeClienteReservou, documentoClienteReservou);

        Ingresso ingresso = reservaPesquisada.getIngresso();
        ingresso.imprimirIngresso();

        System.out.println("Deseja remover a reserva do sistema?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opcaoRemover = Integer.parseInt(scanner.nextLine());

        if(opcaoRemover == 1)
            mapaReservas.remove(idReserva);

    }

    private static void venderIngresso(Vendedor vendedor) {

        Scanner scanner = new Scanner(System.in);
        visualizarSessoes();
        System.out.println("Informe a sessão:");
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
                System.out.printf("Preço = R$ %.2f%n", ingresso.getPreco());
                mapaVendas.put(venda.getId(), venda);

            } else {
                Ingresso ingresso = new Ingresso(sessaoEscolhida, false, opcaoAssento);
                Venda venda = new Venda(ingresso, vendedor);
                mapaVendas.put(venda.getId(), venda);
                System.out.printf("Preço = R$ %.2f%n", ingresso.getPreco());

            }

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
        BufferedReader bufferedReader;
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
        BufferedReader bufferedReader;
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
        System.out.println("Dados de funcionários carregados.");
    }

    private static void carregarDadosFilmes() throws IOException {
        System.out.println("Carregando dados de filmes...");

        String arquivo = "dados/movies.csv";
        BufferedReader bufferedReader;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            String nome = colunas[0];
            String genero = colunas[1];
            int duracaoMins = Integer.parseInt(colunas[2]);
            String censura = colunas[3];
            String diretor = colunas[4];
            Filme filme = new Filme(nome, genero, duracaoMins, censura, diretor);
            mapaFilmes.put(filme.getId(), filme);
        }
        System.out.println("Dados de Filmes carregados.");
    }

    private static void carregarDadosSessoes() throws IOException {
        System.out.println("Carregando dados de sessoes...");

        String arquivo = "dados/sessoes.csv";
        BufferedReader bufferedReader;
        String separador = ",";

        FileReader fileReader = new FileReader(arquivo);
        bufferedReader = new BufferedReader(fileReader);

        //Lê e ignora a primeira linha com cabeçalho das colunas
        String linha = bufferedReader.readLine();

        while ((linha = bufferedReader.readLine()) != null) {
            String[] colunas = linha.split(separador);
            int idFilme = Integer.parseInt(colunas[0]);
            String exibicao = colunas[1];
            String dimensao = colunas[2];
            int dia = Integer.parseInt(colunas[3]);
            String horario = colunas[4];
            int numeroSala = Integer.parseInt(colunas[5]);

            Filme filme = mapaFilmes.get(idFilme);
            SalaCinema salaCinema = mapaSalasCinema.get(numeroSala);

            Sessao sessao = new Sessao(filme, exibicao, dimensao, salaCinema, dia, horario);
            mapaSessoes.put(sessao.getId(), sessao);
        }
        System.out.println("Dados das sessões carregados.");
    }

    private static void carregarDadosSalas() throws IOException {
        System.out.println("Carregando dados das salas...");

        String arquivo = "dados/salasCinema.csv";
        BufferedReader bufferedReader;
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
                    System.out.printf("%s (%s) autenticado com sucesso!%n",
                            funcionarioPesquisado.getNome(),
                            funcionarioPesquisado.getId());
                }else{
                    System.out.printf("%s (%s) não autenticado! Senha incorreta!%n",
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

        ClienteRegistrado clientePesquisado = null;

        do {
            System.out.println("\nDigite o email:");
            //String emailPesquisado = "1";
            String emailPesquisado = scanner.nextLine();

            System.out.println("Digite a senha:");
            //String senhaPesquisada = "6838";
            String senhaPesquisada = scanner.nextLine();

            // Pesquisa no HashMap de Clientes pelo email pesquisado.
            // TODO: Exception (NULL)
            if ((mapaClientes.get(emailPesquisado) != null)) {
                clientePesquisado = mapaClientes.get(emailPesquisado);

                boolean autenticadoSucesso =
                        clientePesquisado.autenticar(senhaPesquisada);

                if (autenticadoSucesso) {
                    System.out.printf("%s autenticado com sucesso!%n",
                            clientePesquisado.getNome());

                } else {
                    System.out.printf("Cliente não autenticado! Senha incorreta!%n");
                    return null;
                }
            } else {
                System.out.println("Cliente não encontrado!");
            }
        } while (clientePesquisado == null);
        return clientePesquisado;
    }

}



