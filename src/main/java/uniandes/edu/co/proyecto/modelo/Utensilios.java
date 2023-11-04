package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="utensilios")
public class Utensilios {

    @EmbeddedId
    private UtensiliosPK pk;

    private String tipo;
    private Float costodanio;


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Utensilios()
    {;}


    public Utensilios(UtensiliosPK pk, Float costodanio, String tipo) {
        this.pk = pk;
        this.costodanio = costodanio;
        this.tipo = tipo;
    }


    public UtensiliosPK getPk() {
        return pk;
    }


    public Float getCostoDanio() {
        return costodanio;
    }


    public void setPk(UtensiliosPK pk) {
        this.pk = pk;
    }


    public void setCostoDanio(Float costodanio) {
        this.costodanio = costodanio;
    }

    

}
