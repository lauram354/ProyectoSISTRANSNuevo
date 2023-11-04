package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tiendas {

    @EmbeddedId
    private TiendasPK pk;
    private String estilo;
 

    
    public Tiendas() {
    }



    public Tiendas(TiendasPK pk, String estilo) {
        this.pk = pk;
        this.estilo = estilo;
    }



    public TiendasPK getPk() {
        return pk;
    }



    public void setPk(TiendasPK pk) {
        this.pk = pk;
    }



    public String getEstilo() {
        return estilo;
    }



    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }


    

}
