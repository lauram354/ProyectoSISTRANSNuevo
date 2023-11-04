package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idproducto;

    private Float precio;
    private String producto;

    

    //CONSTRUCTORS

    public Menu()
    {;}

    public Menu(Float precio, String nombreProducto) {
        this.precio = precio;
        this.producto = nombreProducto;
    }

     //GETTERS
    public Integer getIdProducto() {
        return idproducto;
    }

    public Float getprecio() {
        return precio;
    }

    public String getProducto() {
        return producto;
    }

    //SETTERS
    
    public void setIdProducto(Integer idProducto) {
        this.idproducto = idProducto;
    }

    public void setprecio(Float precio) {
        this.precio = precio;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    

}
