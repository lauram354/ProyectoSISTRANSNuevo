package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LavanderiaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    public LavanderiaPK(Servicios idServicios) {
        super();
        this.idServicio = idServicios;
    }

    public LavanderiaPK() {
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
