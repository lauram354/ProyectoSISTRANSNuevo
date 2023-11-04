package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idproducto;

    private Float costo;
    private String nombreproducto;

    

    //CONSTRUCTORS

    public Productos()
    {;}

    public Productos(Float costo, String nombreproducto) {
        this.costo = costo;
        this.nombreproducto = nombreproducto;
    }

    //GETTERS

    public Integer getIdproducto() {
        return idproducto;
    }

    public Float getCosto() {
        return costo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    //SETTERS
    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    
    

}
