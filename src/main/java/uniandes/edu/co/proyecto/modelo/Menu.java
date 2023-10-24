package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProducto;

    private Float costo;
    private String producto;

    

    //CONSTRUCTORS

    public Menu()
    {;}

    public Menu(Float costo, String nombreProducto) {
        this.costo = costo;
        this.producto = nombreProducto;
    }

     //GETTERS
    public Integer getIdProducto() {
        return idProducto;
    }

    public Float getCosto() {
        return costo;
    }

    public String getProducto() {
        return producto;
    }

    //SETTERS
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    

}
