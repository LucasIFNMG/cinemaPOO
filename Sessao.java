import java.util.Calendar;

class Sessao{
    private Filme filme;
    private boolean isDublado;
    private boolean is3d;
    private SalaCinema sala;
    private Calendar dia;
    private Calendar horario;
    private int assentosDisponiveis;
    private float preco;

    public Sessao(Filme filme, boolean isDublado, boolean is3d, SalaCinema sala, Calendar dia, Calendar horario)
    {
        this.filme = filme;
        this.isDublado = isDublado;
        this.is3d = is3d;
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

    public boolean getIsDublado()
    {
        return this.isDublado;
    }

    public void setIsDublado(boolean isDublado)
    {
        this.isDublado = isDublado;
    }

    public boolean getIs3d()
    {
        return this.is3d;
    }

    public void setIs3d(boolean is3d)
    {
        this.is3d = is3d;
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
     */
    public Calendar getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Calendar dia) {
        this.dia = dia;
    }

    /**
     * @return the horario
     */
    public Calendar getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Calendar horario) {
        this.horario = horario;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @return the assentosDisponiveis
     */
    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public static void main(String[] args) {
        
    }

    


}