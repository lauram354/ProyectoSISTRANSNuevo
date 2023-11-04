package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tiendas {

    @EmbeddedId
    private TiendasPK pk;
    private String nombre;
 

    
    public Tiendas() {
    }



    public Tiendas(TiendasPK pk, String nombre) {
        this.pk = pk;
        this.nombre = nombre;
    }



    public TiendasPK getPk() {
        return pk;
    }



    public void setPk(TiendasPK pk) {
        this.pk = pk;
    }



    public String getnombre() {
        return nombre;
    }



    public void setnombre(String nombre) {
        this.nombre = nombre;
    }


    

}
