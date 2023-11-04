package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InternetPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    private Servicios idservicio;

    public InternetPK(Servicios idservicios) {
        super();
        this.idservicio = idservicios;
    }

    public InternetPK() {
    }

    public Servicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
    }
    
}
