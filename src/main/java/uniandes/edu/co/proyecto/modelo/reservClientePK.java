package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class reservClientePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Clientes_id", referencedColumnName = "id")
    private Clientes idCliente;

    @ManyToOne
    @JoinColumn(name = "Reservas_idReserva", referencedColumnName = "idReserva")
    private Hoteles nombreHotel;

    public reservClientePK() {
    }

    public reservClientePK(Clientes idCliente, Hoteles nombreHotel) {
        this.idCliente = idCliente;
        this.nombreHotel = nombreHotel;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

   
}

