package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MenuBarPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bar_idservicio", referencedColumnName = "idservicio")
    private Bar idservicio;

    @ManyToOne
    @JoinColumn(name = "menu_idproducto", referencedColumnName = "idproducto")
    private Menu producto;

    public MenuBarPK() {
    }

    public MenuBarPK(Bar idservicio, Menu producto) {
        this.idservicio = idservicio;
        this.producto = producto;
    }

    public Bar getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Bar idservicio) {
        this.idservicio = idservicio;
    }

    public Menu getProducto() {
        return producto;
    }

    public void setProducto(Menu producto) {
        this.producto = producto;
    }

   
    
}



