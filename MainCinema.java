import java.text.NumberFormat;
import java.util.Calendar;

class MainCinema{
    public static void main(String[] args) {
    
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    Calendar calendar = Calendar.getInstance();
    Ator atorReiLeao = new Ator("Donald Glover");
    Diretor diretorReiLeao = new Diretor("Jon Favreau");
    Filme reiLeao = new Filme("O Rei Leão", "Drama", 118, 
                              "Traído e exilado de seu reino, o leãozinho Simba(...)", 
                              "Livre", atorReiLeao, diretorReiLeao);

    Cartaz cartaz = new Cartaz(reiLeao);    // Cartaz = Todos os filmes (Lista) e suas respectivas Sessões                    

    SalaCinema sala1 = new SalaCinema(1, 100);
    Sessao sessaoReiLeao = new Sessao(reiLeao, "Legendado", "2D", sala1, calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY));
    Funcionario novoFuncionario = new Funcionario("Lucas", 1, "111.222.333-44");
    
    Ingresso novoIngresso = new Ingresso(sessaoReiLeao, false, novoFuncionario);
    Ingresso novoIngresso2 = new Ingresso(sessaoReiLeao, false, novoFuncionario);

    Cliente novoCliente = new Cliente("Bruno", 1, "123456");
    System.out.println("---------------------------------------------");
    System.out.println("Exibindo Informações do Filme " + reiLeao.getNome());
    System.out.println("---------------------------------------------");
    sessaoReiLeao.recuperarDadosGeral();

    System.out.println("---------------------------------------------");
    System.out.println("Reservando um ingresso...");
    System.out.println("---------------------------------------------");
    if(novoIngresso2.reservarIngresso(novoCliente, 1))
    {
        System.out.println("Reserva efetuada com sucesso!");
    }
    else{
        System.out.println("ERRO na operação de reserva!");
        return;
    }
    System.out.println("---------------------------------------------");
    System.out.println("Exibindo informações da Sessão...");
    System.out.println("---------------------------------------------");
    novoIngresso2.confirmarReservaIngresso(novoIngresso2.getCliente().getDocumento(), 10);
    System.out.println("---------------------------------------------");
  
    novoFuncionario.recuperarDadosPagamentoFunc();
    System.out.println("Vendendo ingressos...");
    System.out.println("---------------------------------------------");
    if(novoIngresso.vender(9)){
        System.out.println("Venda efetuada com sucesso!");
    }
    else{
        System.out.println("ERRO na operação de venda!");
        return;
    }
    System.out.println("---------------------------------------------");

    novoFuncionario.recuperarDadosPagamentoFunc();

    System.out.println("---------------------------------------------");
    String string3 = nf.format(Funcionario.getTotalArrecadadoCinema());
    System.out.println("Total Arrecadado pelo Cinema: " + string3);
    System.out.println("---------------------------------------------");
    
    
    }
}   