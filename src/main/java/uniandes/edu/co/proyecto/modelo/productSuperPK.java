package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class productSuperPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "super_idservicio", referencedColumnName = "idservicio")
    private Super idservicio;

    @ManyToOne
    @JoinColumn(name = "productos_idproducto", referencedColumnName = "idproducto")
    private Productos producto;

    public productSuperPK() {
    }

    public productSuperPK(Super idservicio, Productos producto) {
        this.idservicio = idservicio;
        this.producto = producto;
    }

    public Super getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Super idservicio) {
        this.idservicio = idservicio;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    
}

