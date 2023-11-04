package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class usuReservasPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuarios idusuario;

    @ManyToOne
    @JoinColumn(name = "reservas_idreserva", referencedColumnName = "idreserva")
    private Reservas idreserva;

    public usuReservasPK(Usuarios idusuario, Reservas idreserva) {
        super();
        this.idusuario = idusuario;
        this.idreserva = idreserva;
    }



    public usuReservasPK() {
    }



    public Usuarios getIdusuario() {
        return idusuario;
    }



    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }



    public Reservas getIdreserva() {
        return idreserva;
    }



    public void setIdreserva(Reservas idreserva) {
        this.idreserva = idreserva;
    }


}
