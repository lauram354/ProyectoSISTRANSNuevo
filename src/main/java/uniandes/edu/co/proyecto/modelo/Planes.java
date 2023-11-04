package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="planes")
public class Planes {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtipoplan;
    private String tipo_plan;
    private Float descuento;
    

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    //CONSTRUCTORS

    public Planes() 
    {;}

    public Planes(Float descuento,  Hoteles nombreHotel, String tipo_plan) {
        this.descuento = descuento;
        this.nombreHotel = nombreHotel;
        this.tipo_plan = tipo_plan;
    }

    //GETTERS

    public Integer getIdTipoPlan() {
        return idtipoplan;
    }

    public void setIdTipoPlan(Integer idTipoPlan) {
        this.idtipoplan = idTipoPlan;
    }

    public String getTipo_plan() {
        return tipo_plan;
    }

    public void setTipo_plan(String tipo_plan) {
        this.tipo_plan = tipo_plan;
    }

   

    public Float getDescuento() {
        return descuento;
    }


    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    //SETTERS


    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }


    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }   
    
}

