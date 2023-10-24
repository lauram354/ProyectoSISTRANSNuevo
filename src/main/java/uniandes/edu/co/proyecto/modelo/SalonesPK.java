package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SalonesPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    public SalonesPK(Servicios idServicios) {
        super();
        this.idServicio = idServicios;
    }

    public SalonesPK() {
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
