package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bar")
public class Bar {

    @EmbeddedId
    private BarPK pk;

    private Integer capacidad;
    private String estilo;
    private String nombre;

    
    public Bar() {
    }


    public Bar(BarPK pk, Integer capacidad, String estilo, String nombre) {
        this.pk = pk;
        this.capacidad = capacidad;
        this.estilo = estilo;
        this.nombre = nombre;
    }


    public BarPK getPk() {
        return pk;
    }


    public void setPk(BarPK pk) {
        this.pk = pk;
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


    

}
