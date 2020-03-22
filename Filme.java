class Filme{
    private String nome;
    private String genero;
    private int duracao;
    private String sinopse;
    private String censura;
    private Ator atorPrincipal;
    private Diretor diretor;
    private Data dataLancamento;

    public Filme(String nome, String genero, int duracao, String sinopse, String censura, Ator atorPrincipal, Diretor diretor)
    {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.censura = censura;
        this.atorPrincipal = atorPrincipal;
        this.diretor = diretor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the censura
     */
    public String getCensura() {
        return censura;
    }

    /**
     * @param censura the censura to set
     */
    public void setCensura(String censura) {
        this.censura = censura;
    }

    /**
     * @return the atorPrincipal
     */
    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    /**
     * @param atorPrincipal the atorPrincipal to set
     */
    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    /**
     * @return the diretor
     */
    public Diretor getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the dataLancamento
     */
    public Data getDataLancamento() {
        return dataLancamento;
    }

    public void recuperarDados()
    {
        System.out.println("Filme: " + this.getNome()
                        + "\nGênero: " + this.getGenero()
                        + "\nDuração: " + this.getDuracao() + " mins"    
                        + "\nSinopse: " + this.getSinopse()
                        + "\nCensura: " + this.getCensura() );
    }

    public static void main(String[] args) {
        
    }


}