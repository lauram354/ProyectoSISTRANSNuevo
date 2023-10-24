package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class menuRestoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Resto_idServicio", referencedColumnName = "idServicio")
    private Resto idServicio;

    @ManyToOne
    @JoinColumn(name = "Menu_idProducto", referencedColumnName = "idProducto")
    private Menu producto;

    public menuRestoPK() {
    }

    public menuRestoPK(Resto idServicio, Menu producto) {
        this.idServicio = idServicio;
        this.producto = producto;
    }

    public Resto getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Resto idServicio) {
        this.idServicio = idServicio;
    }

    public Menu getProducto() {
        return producto;
    }

    public void setProducto(Menu producto) {
        this.producto = producto;
    }

    
}


