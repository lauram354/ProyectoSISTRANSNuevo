package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class usuHotelPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Usuarios_id", referencedColumnName = "id")
    private Usuarios idUsuario;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    public usuHotelPK(Usuarios idUsuario, Hoteles nombreHotel) {
        super();
        this.idUsuario = idUsuario;
        this.nombreHotel = nombreHotel;
    }



    public usuHotelPK() {
    }



    public Usuarios getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Hoteles getNombreHotel() {
        return nombreHotel;
    }



    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }    

}
