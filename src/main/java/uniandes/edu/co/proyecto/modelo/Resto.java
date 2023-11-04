package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="resto")
public class Resto {

    @EmbeddedId
    private RestoPK pk;

    private Integer capacidad;
    private String estilo;
    private String nombre;

    
    public Resto() {
    }



    public Resto(RestoPK pk, Integer capacidad, String estilo, String nombre) {
        this.pk = pk;
        this.capacidad = capacidad;
        this.estilo = estilo;
        this.nombre = nombre;
    }


    public Integer getCapacidad() {
        return capacidad;
    }


    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }


    public String getEstilo() {
        return estilo;
    }


    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public RestoPK getPk() {
        return pk;
    }


    public void setPk(RestoPK pk) {
        this.pk = pk;
    }


    

}
