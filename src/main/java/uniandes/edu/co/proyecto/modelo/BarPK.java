package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BarPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    private Servicios idservicio;

    public BarPK(Servicios idServicios) {
        super();
        this.idservicio = idServicios;
    }

    public BarPK() {
    }

    public Servicios getIdServicio() {
        return idservicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idservicio = idServicio;
    }
    
}
