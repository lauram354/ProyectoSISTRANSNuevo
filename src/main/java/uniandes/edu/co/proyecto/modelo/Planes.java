package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Planes")
public class Planes {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo_plan;
    private Float descuento;
    

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    //CONSTRUCTORS

    public Planes() 
    {;}

    public Planes(Float descuento,  Hoteles nombreHotel) {
        this.descuento = descuento;
        this.nombreHotel = nombreHotel;
    }

    //GETTERS

    public String getTipo() {
        return tipo_plan;
    }

    public Float getDescuento() {
        return descuento;
    }


    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    //SETTERS

    public void setTipo(String tipo) {
        this.tipo_plan = tipo;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }


    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }   
    
}

