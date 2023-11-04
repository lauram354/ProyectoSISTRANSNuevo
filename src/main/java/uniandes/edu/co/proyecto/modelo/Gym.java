package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gym")
public class Gym {

    @EmbeddedId
    private GymPK pk;

    private Integer capacidad;


    public Gym()
    {;}

    public Gym(Servicios idServicio, Integer capacidad) {
        this.pk = new GymPK(idServicio);
        this.capacidad = capacidad;

    }

    public GymPK getPk() {
        return pk;
    }

    public Integer getCapacidad() {
        return capacidad;
    }


    public void setPk(GymPK pk) {
        this.pk = pk;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
