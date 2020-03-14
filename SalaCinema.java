class SalaCinema{
    private int numero;
    private int capacidadeAssentos;

    public SalaCinema(int numero, int capacidadeAssentos)
    {
        this.numero = numero;
        this.capacidadeAssentos = capacidadeAssentos;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the capacidadeAssentos
     */
    public int getCapacidadeAssentos() {
        return capacidadeAssentos;
    }

    /**
     * @param capacidadeAssentos the capacidadeAssentos to set
     */
    public void setCapacidadeAssentos(int capacidadeAssentos) {
        this.capacidadeAssentos = capacidadeAssentos;
    }

    public static void main(String[] args) {
        
    }

}