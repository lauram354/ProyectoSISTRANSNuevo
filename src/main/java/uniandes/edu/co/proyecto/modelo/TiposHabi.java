package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TiposHabi")
public class TiposHabi {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo;
    private Float costo_alojamiento;
    private Integer capacidad;

    //CONSTRUCTORS

    public TiposHabi()
    {;}

    public TiposHabi(Integer capacidad, Float costo) {
        this.capacidad = capacidad;
        this.costo_alojamiento = costo;
    }

    //GETTERS

    public String getTipo() {
        return tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getCosto_alojamiento() {
        return costo_alojamiento;
    } 
    //SETTERS

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto_alojamiento(Float costo_alojamiento) {
        this.costo_alojamiento = costo_alojamiento;
    }

    
}
