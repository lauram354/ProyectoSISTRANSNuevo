package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MenuBarPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Bar_idServicio", referencedColumnName = "idServicio")
    private Bar idServicio;

    @ManyToOne
    @JoinColumn(name = "Menu_idProducto", referencedColumnName = "idProducto")
    private Menu producto;

    public MenuBarPK() {
    }

    public MenuBarPK(Bar idServicio, Menu producto) {
        this.idServicio = idServicio;
        this.producto = producto;
    }

    public Bar getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Bar idServicio) {
        this.idServicio = idServicio;
    }

    public Menu getProducto() {
        return producto;
    }

    public void setProducto(Menu producto) {
        this.producto = producto;
    }

   
    
}



