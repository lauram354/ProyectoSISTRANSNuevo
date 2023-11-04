package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet {

    @EmbeddedId
    private InternetPK pk;

    private Integer capacidad;


    public Internet()
    {;}

    public Internet(Servicios idServicio, Integer capacidad) {
        this.pk = new InternetPK(idServicio);
        this.capacidad = capacidad;

    }

    public InternetPK getPk() {
        return pk;
    }

    public Integer getCapacidad() {
        return capacidad;
    }



    public void setPk(InternetPK pk) {
        this.pk = pk;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
