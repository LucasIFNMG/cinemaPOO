package br.edu.ifnmg.cinema.entidade;

public class Reserva extends Venda{

    private final String id;
    private final ClienteRegistrado clienteRegistrado;
    private int totalReservas = 0;

    public Reserva(Ingresso ingresso, ClienteRegistrado clienteRegistrado) {
        super(ingresso);
        this.ingresso = ingresso;
        this.clienteRegistrado = clienteRegistrado;
        totalReservas++;
        this.id = getCodigoReserva();
    }

    public String getCodigoReserva() {
        return totalReservas + this.clienteRegistrado.getDocumento();
    }

    public ClienteRegistrado getClienteRegistrado() {
        return clienteRegistrado;
    }

    public Ingresso getIngresso(){
        return ingresso;
    }
}
