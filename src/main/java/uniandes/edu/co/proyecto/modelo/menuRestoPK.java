package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class menuRestoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "resto_idservicio", referencedColumnName = "idservicio")
    private Resto idservicio;

    @ManyToOne
    @JoinColumn(name = "menu_idproducto", referencedColumnName = "idproducto")
    private Menu producto;

    public menuRestoPK() {
    }

    public menuRestoPK(Resto idservicio, Menu producto) {
        this.idservicio = idservicio;
        this.producto = producto;
    }

    public Resto getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Resto idservicio) {
        this.idservicio = idservicio;
    }

    public Menu getProducto() {
        return producto;
    }

    public void setProducto(Menu producto) {
        this.producto = producto;
    }

    
}


