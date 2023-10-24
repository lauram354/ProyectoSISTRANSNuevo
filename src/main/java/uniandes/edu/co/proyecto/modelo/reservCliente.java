package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reservCliente")
public class reservCliente {

    @EmbeddedId
    private reservClientePK pk;

    
    public reservCliente() {
    }
    

    public reservCliente(reservClientePK pk) {
        this.pk = pk;
    }


    public reservClientePK getPk() {
        return pk;
    }

    public void setPk(reservClientePK pk) {
        this.pk = pk;
    }

    

}
