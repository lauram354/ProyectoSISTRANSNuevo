package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Utensilios")
public class Utensilios {

    @EmbeddedId
    private UtensiliosPK pk;

    private Float costoDanio;


    public Utensilios()
    {;}


    public Utensilios(UtensiliosPK pk, Float costoDanio) {
        this.pk = pk;
        this.costoDanio = costoDanio;
    }


    public UtensiliosPK getPk() {
        return pk;
    }


    public Float getCostoDanio() {
        return costoDanio;
    }


    public void setPk(UtensiliosPK pk) {
        this.pk = pk;
    }


    public void setCostoDanio(Float costoDanio) {
        this.costoDanio = costoDanio;
    }

    

}
