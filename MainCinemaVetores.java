import java.text.NumberFormat;
import java.math.BigDecimal;
import java.util.Calendar;
// TODO: Add Listas


class MainCinemaVetores{
    public static void main(String[] args) {
    
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        Filme meusFilmes[];
        meusFilmes = new Filme[10];

        Calendar calendar = Calendar.getInstance();
        Ator atorReiLeao = new Ator("Donald Glover");
        Diretor diretorReiLeao = new Diretor("Jon Favreau");
        Filme reiLeao = new Filme("O Rei Leão", "Drama", 118, 
                                "Traído e exilado de seu reino, o leãozinho Simba(...)", 
                                "Livre", atorReiLeao, diretorReiLeao);  
                                
        int totalFilmes;    // Contador
        totalFilmes = Filme.getTotalFilmes()-1;
        System.out.println("Total filmes = " + totalFilmes);
        meusFilmes[totalFilmes++] = reiLeao;
        System.out.println("Total filmes = " + totalFilmes);

        SalaCinema sala1 = new SalaCinema(1, 100);
        Sessao sessaoReiLeao = new Sessao(reiLeao, "Legendado", "2D", sala1, calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY));
        Funcionario novoFuncionario = new Funcionario("Lucas", 1, "111.222.333-44", new BigDecimal("1000.00"));
        
        Ingresso novoIngresso = new Ingresso(sessaoReiLeao, false, novoFuncionario);
        Ingresso novoIngresso2 = new Ingresso(sessaoReiLeao, false, novoFuncionario);

        Cliente novoCliente = new Cliente("Bruno", 1, "123456");
        /*System.out.println("---------------------------------------------");
        System.out.println("Exibindo Informações do Filme " + reiLeao.getNome());
        System.out.println("---------------------------------------------");
        sessaoReiLeao.recuperarDadosFilmeSessao();

        System.out.println("---------------------------------------------");
        System.out.println("Reservando um ingresso...");
        System.out.println("---------------------------------------------");
        */
        novoIngresso2.reservarIngresso(novoCliente, 1);
        /*
        System.out.println("---------------------------------------------");
        System.out.println("Exibindo informações da Sessão...");
        System.out.println("---------------------------------------------");
        */
        novoIngresso2.confirmarReservaIngresso(novoIngresso2.getCliente().getDocumento(), 10);
        /*System.out.println("---------------------------------------------");
    
        novoFuncionario.recuperarDadosPagamentoFunc();
        System.out.println("Vendendo ingressos...");
        System.out.println("---------------------------------------------");
        */
        novoIngresso.vender(9);
        System.out.println("---------------------------------------------");

        novoFuncionario.recuperarDadosPagamentoFunc();

        System.out.println("---------------------------------------------");
        String string3 = nf.format(Funcionario.getTotalArrecadadoCinema());
        System.out.println("Total Arrecadado pelo Cinema: " + string3);
        System.out.println("---------------------------------------------");
        
        System.out.println("Alterando a Sala de uma sessão...");
        System.out.println("---------------------------------------------");
        SalaCinema sala2 = new SalaCinema(2, 100);
        sessaoReiLeao.setSala(sala2);
        System.out.println("Nova sala da sessão Rei Leão: " + sessaoReiLeao.getSala().getNumeroSala());
        System.out.println("---------------------------------------------");

        Cartaz cartaz = new Cartaz(sessaoReiLeao);    // Cartaz = Todos as Sessões e seus respectivos filmes
        System.out.println("Exibindo Filmes em Cartaz...");
        System.out.println("---------------------------------------------");
        cartaz.recuperarSessoes();

        Ator atorMatrix4 = new Ator("Keanu Reeves");
        Diretor diretorMatrix4 = new Diretor("Lana Wachowski");
        Filme matrix4 = new Filme("The Matrix 4", "Ficção Científica", 120, 
                                "Continuação da franquia Matrix", 
                                "16", atorMatrix4, diretorMatrix4);
        
        System.out.println("Total filmes = " + totalFilmes);
        meusFilmes[totalFilmes++] = matrix4;
        System.out.println("Total filmes = " + totalFilmes);

        Lancamento novoLancamento = new Lancamento(matrix4);
        System.out.println("---------------------------------------------");
        System.out.println("Exibindo Filmes em Lançamento...");
        System.out.println("---------------------------------------------");
        novoLancamento.getFilme().recuperarDados();

        System.out.println("---------------------------------------------");
        System.out.println("Array Filmes:");
        
        for (int i = 0; i < meusFilmes.length; i++) 
        {
            try {
                System.out.printf("%s\n", meusFilmes[i].getNome());

            } catch (NullPointerException e) {
                System.out.println(e);
                // System.out.printf("%s\n", meusFilmes[i].getNome());
                continue;
            }
        
        }
        System.out.println("---------------------------------------------");
        System.out.println("Array Filmes (Enhanced For):");

        for(Filme x: meusFilmes)
        {
            try {
                System.out.println(x.getNome());
            } catch (NullPointerException e) {
                System.out.println(e);
                continue;
            }
        }


    }
}