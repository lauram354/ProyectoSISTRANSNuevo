package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class Clientes {

    @EmbeddedId
    private ClientesPK pk;

    private Boolean paz_y_salvo;
    

    
    public Clientes() {
    }



    public Clientes(ClientesPK pk, Boolean paz_y_salvo) {
        this.pk = pk;
        this.paz_y_salvo = paz_y_salvo;
    }



    public ClientesPK getPk() {
        return pk;
    }



    public void setPk(ClientesPK pk) {
        this.pk = pk;
    }



    public Boolean getPaz_y_salvo() {
        return paz_y_salvo;
    }



    public void setPaz_y_salvo(Boolean paz_y_salvo) {
        this.paz_y_salvo = paz_y_salvo;
    }

    
    
}
