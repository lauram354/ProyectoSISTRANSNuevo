package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="menuresto")
public class menuResto {

    @EmbeddedId
    private menuRestoPK pk;

    public menuResto() {
    }

    public menuResto(menuRestoPK pk) {
        this.pk = pk;
    }

    public menuRestoPK getPk() {
        return pk;
    }

    public void setPk(menuRestoPK pk) {
        this.pk = pk;
    }    

}

