package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscina")
public class Piscina {

    @EmbeddedId
    private PiscinasPK pk;

    private Integer capacidad;
    private Float profundidad;


    public Piscina()
    {;}

    public Piscina(Servicios idServicio, Integer capacidad, Float profundidad) {
        this.pk = new PiscinasPK(idServicio);
        this.capacidad = capacidad;
        this.profundidad = profundidad;

    }

    public PiscinasPK getPk() {
        return pk;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getProfundidad() {
        return profundidad;
    }


    public void setPk(PiscinasPK pk) {
        this.pk = pk;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }


}
