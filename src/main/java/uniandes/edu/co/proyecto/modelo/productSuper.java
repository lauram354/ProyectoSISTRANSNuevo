package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productsuper")
public class productSuper {

    @EmbeddedId
    private productSuperPK pk;

    public productSuper() {
    }

    public productSuper(productSuperPK pk) {
        this.pk = pk;
    }

    public productSuperPK getPk() {
        return pk;
    }

    public void setPk(productSuperPK pk) {
        this.pk = pk;
    }

    

}


