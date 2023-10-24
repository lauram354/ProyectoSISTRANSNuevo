package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Lavanderia")
public class Lavanderia {

    @EmbeddedId
    private LavanderiaPK pk;

    private String tipoPrenda;


    public Lavanderia()
    {;}


    public Lavanderia(LavanderiaPK pk, String tipoPrenda) {
        this.pk = pk;
        this.tipoPrenda = tipoPrenda;
    }


    public LavanderiaPK getPk() {
        return pk;
    }


    public String getTipoPrenda() {
        return tipoPrenda;
    }


    public void setPk(LavanderiaPK pk) {
        this.pk = pk;
    }


    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    
   

}
