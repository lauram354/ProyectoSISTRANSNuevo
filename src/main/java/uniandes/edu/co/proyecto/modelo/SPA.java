package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="spa")
public class SPA {

    @EmbeddedId
    private SpaPK pk;

    private Integer duracion;


    public SPA()
    {;}

    public SPA(Servicios idServicio, Integer duracion) {
        this.pk = new SpaPK(idServicio);
        this.duracion = duracion;

    }

    public SpaPK getPk() {
        return pk;
    }

    public Integer getDuracion() {
        return duracion;
    }



    public void setPk(SpaPK pk) {
        this.pk = pk;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

}
