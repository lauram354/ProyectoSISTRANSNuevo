package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SuperPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    private Servicios idservicio;

    public SuperPK(Servicios idservicios) {
        super();
        this.idservicio = idservicios;
    }

    public SuperPK() {
    }

    public Servicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
    }
    
}
