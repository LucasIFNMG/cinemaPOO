class Cartaz
{
    Filme filme;
    Data dataInicio;
    Data dataTermino;

    public Cartaz(Filme filme)
    {
        this.filme = filme;
    }

    /**
     * @return the filme
     */
    public Filme getfilme() {
        return filme;
    }

    /**
     * @param filme the filme to set
     */
    public void setfilme(Filme filme) {
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

    /**
     * @return the dataTermino
     */
    public Data getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(Data dataTermino) {
        this.dataTermino = dataTermino;
    }

    public static void main(String[] args) {
        
    }

}