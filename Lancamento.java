class Lancamento
{
    private Filme filme;
    private Data dataInicio;
    // private String status; // "Em breve nos cinemas" , "Em Abril nos cinemas"

    public Lancamento(Filme filme)
    {
        this.filme = filme;
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

    /**
     * @return the dataInicio
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void recuperarLancamentos()
    {
        this.getFilme().recuperarDados();
    }

    public static void main(String[] args) {
        
    }



}