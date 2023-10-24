package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class productSuperPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Super_idServicio", referencedColumnName = "idServicio")
    private Super idServicio;

    @ManyToOne
    @JoinColumn(name = "Productos_idProducto", referencedColumnName = "idProducto")
    private Productos producto;

    public productSuperPK() {
    }

    public productSuperPK(Super idServicio, Productos producto) {
        this.idServicio = idServicio;
        this.producto = producto;
    }

    public Super getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Super idServicio) {
        this.idServicio = idServicio;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    
}

