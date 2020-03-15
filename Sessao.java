import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

class Sessao{
    private Filme filme;
    private String exibicao;
    private String dimensao;
    private SalaCinema sala;
    private int dia;
    private int horario;
    private int assentosDisponiveis;
    private float preco;
    // private boolean isPreEstreia;

    public Sessao(Filme filme, String exibicao, String dimensao, SalaCinema sala, int dia, int horario)
    {
        this.filme = filme;
        this.exibicao = exibicao;
        this.dimensao = dimensao;
        this.sala = sala;
        this.dia = dia;
        this.horario = horario;
        this.assentosDisponiveis = sala.getCapacidadeAssentos();
    }

    /**
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getExibicao()
    {
        return this.exibicao;
    }

    public void setIsDublado(String exibicao)
    {
        this.exibicao = exibicao;
    }

    public String getDimensao()
    {
        return this.dimensao;
    }

    public void setDimensao(String dimensao)
    {
        this.dimensao = dimensao;
    }

    /**
     * @return the sala
     */
    public SalaCinema getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(SalaCinema sala) {
        this.sala = sala;
    }

    /**
     * @return the dia
    // calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.HOUR_OF_DAY)
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the horario
     */
    public int getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     * TODO: Verificar os horários já ocupados, no caso de adicionar novos filmes em Cartaz
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * @return the assentosDisponiveis
     */
    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public boolean reservarAssentos(int quantidade)
    {
        if(this.getAssentosDisponiveis() >= quantidade)
        {
            this.assentosDisponiveis-= quantidade;
            return true;
        }
        else
        {
            return false;
        }
    }

    public float getPreco() {

        switch(this.dia){
            // 1: Domingo
            case 1:
                if(this.dimensao == "3D")
                {
                    this.preco = 30.00f;
                    break;
                }
                else
                {
                    this.preco = 26.00f;
                    break;
                }
            // 2: Segunda-feira
            case 2:
                if(this.dimensao == "3D")
                {
                    this.preco = 20.00f;
                    break;
                }
                else
                {
                    this.preco = 18.00f;
                    break;
                }
            // 3: Terça-feira
            case 3:
                if(this.dimensao == "3D")
                {
                    this.preco = 22.00f;
                    break;
                }
                else
                {
                    this.preco = 20.00f;
                    break;
                }
            // 4: Quarta-feira
            case 4:
                if(this.dimensao == "3D")
                {
                    this.preco = 20.00f;
                    break;
                }
                else
                {
                    this.preco = 18.00f;
                    break;
                }
            // 5: Quinta-feira
            case 5:
                if(this.dimensao == "3D")
                {
                    this.preco = 22.00f;
                    break;
                }
                else
                {
                    this.preco = 20.00f;
                    break;
                }
            // 6: Sexta-feira
            case 6:
                if(this.dimensao == "3D")
                {
                    this.preco = 22.00f;
                    break;
                }
                else
                {
                    this.preco = 20.00f;
                    break;
                }
            // 7: Sábado
            case 7:
                if(this.dimensao == "3D")
                {
                    this.preco = 30.00f;
                    break;
                }
                else
                {
                    preco = 26.00f;
                    break;
                }
        }
        return preco;
    }

    public void recuperarDados()
    {
        this.filme.recuperarDados();
        System.out.println("Exibição: " + this.getExibicao()
                        + "\nDimensão: " + this.getDimensao() 
                        + "\nDia: " + this.getDia()
                        + "\nHorário: " + this.getHorario()
                        + "\nPreço: R$ " + this.getPreco()
                        + "\nSala: " + this.sala.getNumeroSala() );
                        // + "\nAssentos Disponíveis: " + this.getAssentosDisponiveis() );
    }

    public Filme getSessao(Filme filme)
    {
        return filme;
    }
    public static void main(String[] args) {
        
    }

}