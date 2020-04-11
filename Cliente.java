class Cliente{
    private final String nome;
    private final int id;
    private String documento;

    public Cliente(String nome, int id, String documento)
    {

        if(id <= 0)
            throw new IllegalArgumentException(
                "ID inválido!");
        
        this.nome = nome;
        this.id = id;
        this.documento = documento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public static void main(String[] args) {
        
    }
}