package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class usuHotelPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Usuarios_id", referencedColumnName = "id")
    private usuarios idUsuario;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    public usuHotelPK(usuarios idUsuario, Hoteles nombreHotel) {
        super();
        this.idUsuario = idUsuario;
        this.nombreHotel = nombreHotel;
    }



    public usuHotelPK() {
    }



    public usuarios getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Hoteles getNombreHotel() {
        return nombreHotel;
    }



    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }    

}
