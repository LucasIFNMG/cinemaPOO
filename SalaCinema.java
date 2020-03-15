class SalaCinema{
    private int numeroSala;
    private int capacidadeAssentos;

    public SalaCinema(int numeroSala, int capacidadeAssentos)
    {
        this.numeroSala = numeroSala;
        this.capacidadeAssentos = capacidadeAssentos;
    }

    /**
     * @return the numero
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
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