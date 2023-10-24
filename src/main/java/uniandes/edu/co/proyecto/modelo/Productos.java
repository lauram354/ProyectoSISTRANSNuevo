package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProducto;

    private Float costo;
    private String nombreProducto;

    

    //CONSTRUCTORS

    public Productos()
    {;}

    public Productos(Float costo, String nombreProducto) {
        this.costo = costo;
        this.nombreProducto = nombreProducto;
    }

    //GETTERS

    public Integer getIdProducto() {
        return idProducto;
    }

    public Float getCosto() {
        return costo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    //SETTERS
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    
    

}
