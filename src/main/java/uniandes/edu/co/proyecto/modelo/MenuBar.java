package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="menubar")
public class MenuBar {

    @EmbeddedId
    private MenuBarPK pk;

    public MenuBar() {
    }

    public MenuBar(MenuBarPK pk) {
        this.pk = pk;
    }

    public MenuBarPK getPk() {
        return pk;
    }

    public void setPk(MenuBarPK pk) {
        this.pk = pk;
    }

     

}

