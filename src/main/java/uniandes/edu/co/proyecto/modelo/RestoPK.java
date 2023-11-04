package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RestoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    private Servicios idservicio;

    public RestoPK(Servicios idservicios) {
        super();
        this.idservicio = idservicios;
    }

    public RestoPK() {
    }

    public Servicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
    }
    
}
