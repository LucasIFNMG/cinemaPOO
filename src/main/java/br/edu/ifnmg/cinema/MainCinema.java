package br.edu.ifnmg.cinema;

import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.edu.ifnmg.cinema.entidade.*;

class MainCinema{
    private static HashMap <String, Funcionario> mapaFuncionarios = new HashMap<>();
    private static HashMap <String, Reserva> mapaReservas = new HashMap<>();

    public static void main(String[] args) {

        // Gerenciar as vendas e reservas de ingresso

        Funcionario funcionario = autenticarFuncionario();
        Scanner scanner = new Scanner(System.in);
        int operacao = 0;

        // Menu ADMIN (nivelAcesso = ESPECIAL)

        if (funcionario instanceof Administrador) {

            do {
                System.out.println("MENU ADMIN");
                System.out.println("Digite uma opção:");
                System.out.println("1: Vender Ingresso");
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

            } while (operacao != 4);
        }

    }

    private static Funcionario autenticarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        Funcionario funcionarioPesquisado = null;

        do{
            System.out.println("\nDigite o ID do funcionario:");
            //String numeroPesquisado = "1";
            String idPesquisado = scanner.next();

            System.out.println("Digite a senha:");
            //String senhaPesquisada = "6838";
            String senhaPesquisada = scanner.next();

            // Pesquisa no HashMap de Contas pelo numero pesquisado.
            if ((mapaFuncionarios.get(idPesquisado) != null)) {
                funcionarioPesquisado = (Funcionario) mapaFuncionarios.get(idPesquisado);

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

    public Reserva consultarReserva(String codigoReserva){
        //TODO: Validar
        Reserva reserva = (Reserva)mapaReservas.get(codigoReserva);
        return reserva;
    }
}



