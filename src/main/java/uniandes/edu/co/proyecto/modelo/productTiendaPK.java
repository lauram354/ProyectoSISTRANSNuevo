package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class productTiendaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "tiendas_idservicio", referencedColumnName = "idservicio")
    private Tiendas idservicio;

    @ManyToOne
    @JoinColumn(name = "productos_idproducto", referencedColumnName = "idproducto")
    private Productos producto;

    public productTiendaPK() {
    }

    public productTiendaPK(Tiendas idservicio, Productos producto) {
        this.idservicio = idservicio;
        this.producto = producto;
    }

    public Tiendas getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Tiendas idservicio) {
        this.idservicio = idservicio;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

}
