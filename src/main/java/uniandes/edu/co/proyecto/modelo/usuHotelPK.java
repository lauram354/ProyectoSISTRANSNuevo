package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class usuHotelPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuarios idusuario;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    public usuHotelPK(Usuarios idusuario, Hoteles nombreHotel) {
        super();
        this.idusuario = idusuario;
        this.nombreHotel = nombreHotel;
    }



    public usuHotelPK() {
    }



    public Usuarios getIdusuario() {
        return idusuario;
    }



    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }



    public Hoteles getNombreHotel() {
        return nombreHotel;
    }



    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }    

}
