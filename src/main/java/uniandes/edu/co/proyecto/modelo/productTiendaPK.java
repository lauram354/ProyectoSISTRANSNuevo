package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class productTiendaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Tiendas_idServicio", referencedColumnName = "idServicio")
    private Tiendas idServicio;

    @ManyToOne
    @JoinColumn(name = "Productos_idProducto", referencedColumnName = "idProducto")
    private Productos producto;

    public productTiendaPK() {
    }

    public productTiendaPK(Tiendas idServicio, Productos producto) {
        this.idServicio = idServicio;
        this.producto = producto;
    }

    public Tiendas getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Tiendas idServicio) {
        this.idServicio = idServicio;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

   

   
}

