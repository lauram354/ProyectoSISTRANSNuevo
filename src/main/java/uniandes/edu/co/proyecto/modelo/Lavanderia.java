package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="lavanderia")
public class Lavanderia {

    @EmbeddedId
    private LavanderiaPK pk;

    private String tipoprenda;


    public Lavanderia()
    {;}


    public Lavanderia(LavanderiaPK pk, String tipoprenda) {
        this.pk = pk;
        this.tipoprenda = tipoprenda;
    }


    public LavanderiaPK getPk() {
        return pk;
    }


    public String getTipoprenda() {
        return tipoprenda;
    }


    public void setPk(LavanderiaPK pk) {
        this.pk = pk;
    }


    public void setTipoprenda(String tipoprenda) {
        this.tipoprenda = tipoprenda;
    }

    
   

}
