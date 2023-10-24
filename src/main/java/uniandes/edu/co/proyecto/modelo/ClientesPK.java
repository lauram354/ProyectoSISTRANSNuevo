package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ClientesPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuarios id;

    public ClientesPK(Usuarios id) {
        super();
        this.id = id;
    }

    public ClientesPK() {
    }

    public Usuarios getId() {
        return id;
    }

    public void setId(Usuarios id) {
        this.id = id;
    }

    
}
