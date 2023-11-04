package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="super")
public class Super {

    @EmbeddedId
    private SuperPK pk;
    private String estilo;
 

    
    public Super() {
    }



    public Super(SuperPK pk, String estilo) {
        this.pk = pk;
        this.estilo = estilo;
    }



    public SuperPK getPk() {
        return pk;
    }



    public void setPk(SuperPK pk) {
        this.pk = pk;
    }



    public String getEstilo() {
        return estilo;
    }



    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    
    

}
