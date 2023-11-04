package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="producttienda")
public class productTienda {

    @EmbeddedId
    private productTiendaPK pk;

    public productTienda() {
    }

    public productTienda(productTiendaPK pk) {
        this.pk = pk;
    }

    public productTiendaPK getPk() {
        return pk;
    }

    public void setPk(productTiendaPK pk) {
        this.pk = pk;
    }

    

}

