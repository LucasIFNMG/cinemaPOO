import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

class MainCinema{
    public static void main(String[] args) {

    Calendar calendar = Calendar.getInstance();
    Ator novoAtor = new Ator("Donald Glover");
    Diretor novoDiretor = new Diretor("Jon Favreau");
    Filme reiLeao = new Filme("Rei Leão", "Drama", 118,
                    "Traído e exilado de seu reino, o leãozinho Simba precisa descobrir como crescer e retomar seu destino como herdeiro real nas planícies da savana africana.", 
                    "Livre", novoAtor, novoDiretor);

    SalaCinema sala1 = new SalaCinema(1, 100);
    Sessao sessaoReiLeao = new Sessao(reiLeao, "Legendado", "2D", sala1, calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY));
    Funcionario novoFuncionario = new Funcionario("Lucas", 1, "111.222.333-44");
    
    Ingresso novoIngresso = new Ingresso(sessaoReiLeao, false, novoFuncionario);
    novoIngresso.vender(2);

    Cartaz cartaz = new Cartaz(sessaoReiLeao);    // Cartaz = Todos os filmes (Vetor) e suas respectivas Sessões

    sessaoReiLeao.recuperarDados();

    System.out.println("Total de Vendas do Func. x: " + novoFuncionario.getTotalVendas());

    }
    
}