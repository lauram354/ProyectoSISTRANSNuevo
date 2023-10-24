package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SpaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    public SpaPK(Servicios idServicios) {
        super();
        this.idServicio = idServicios;
    }

    public SpaPK() {
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
