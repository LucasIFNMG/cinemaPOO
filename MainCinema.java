import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

class MainCinema{
    public static void main(String[] args) {

    Calendar calendar = Calendar.getInstance();
    Ator atorReiLeao = new Ator("Donald Glover");
    Diretor diretorReiLeao = new Diretor("Jon Favreau");
    Filme reiLeao = new Filme("Rei Leão", "Drama", 118,
                    "Traído e exilado de seu reino, o leãozinho Simba precisa descobrir como crescer e retomar seu destino como herdeiro real nas planícies da savana africana.", 
                    "Livre", atorReiLeao, diretorReiLeao);

    Cartaz cartaz = new Cartaz(reiLeao);    // Cartaz = Todos os filmes (Lista) e suas respectivas Sessões                    

    SalaCinema sala1 = new SalaCinema(1, 100);
    Sessao sessaoReiLeao = new Sessao(reiLeao, "Legendado", "2D", sala1, calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY));
    Funcionario novoFuncionario = new Funcionario("Lucas", 1, "111.222.333-44");
    
    Ingresso novoIngresso = new Ingresso(sessaoReiLeao, false, novoFuncionario);
    novoIngresso.vender(2);

    sessaoReiLeao.recuperarDados();

    System.out.println("Total de Vendas do Func: " + novoFuncionario.getTotalVendas());
    System.out.println("Total de Vendas do Cinema: " + Funcionario.getTotalVendasCinema());
    System.out.println("---------------------------------------------");

    Ingresso novoIngresso2 = new Ingresso(sessaoReiLeao, false, novoFuncionario);

    Cliente novoCliente = new Cliente("Bruno", 1, "123456");

    System.out.println("---------------------------------------------");

    if(novoIngresso2.reservarIngresso(novoCliente, 5) == true)
    {
        System.out.println("Reserva efetuada com sucesso!");
    }

    System.out.println("---------------------------------------------");

    System.out.println("Nº de Ingressos (Depois que reservou): " + novoIngresso2.getSessao().getAssentosDisponiveis());
    System.out.println("Total de Vendas do Func: " + novoFuncionario.getTotalVendas());
    System.out.println("Total de Vendas do Cinema: " + Funcionario.getTotalVendasCinema());
    System.out.println("---------------------------------------------");

    novoIngresso2.confirmarReservaIngresso(novoIngresso2.getCliente().getDocumento(), 5);

    System.out.println("Total de Vendas do Func: " + novoFuncionario.getTotalVendas());
    System.out.println("Total de Vendas do Cinema: " + Funcionario.getTotalVendasCinema());
    System.out.println("---------------------------------------------");




    }
    
}