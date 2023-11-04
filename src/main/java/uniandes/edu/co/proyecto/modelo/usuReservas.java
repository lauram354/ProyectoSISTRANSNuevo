package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usureservas")
public class usuReservas {

    @EmbeddedId
    private usuReservasPK pk;

    public usuReservas() {
    }

    public usuReservas(usuReservasPK pk) {
        this.pk = pk;
    }

    public usuReservasPK getPk() {
        return pk;
    }

    public void setPk(usuReservasPK pk) {
        this.pk = pk;
    }

    

}
