class Cartaz
{
    Sessao sessao;
    Data dataInicio;
    Data dataTermino;

    public Cartaz(Sessao sessao)
    {
        this.sessao = sessao;
    }

    /**
     * @return the sessao
     */
    public Sessao getsessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setsessao(Sessao sessao) {
        this.sessao = sessao;
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