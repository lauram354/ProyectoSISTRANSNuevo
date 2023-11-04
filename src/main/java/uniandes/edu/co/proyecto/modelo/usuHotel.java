package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuhotel")
public class usuHotel {

    @EmbeddedId
    private usuHotelPK pk;

    public usuHotel()
    {;}

    public usuHotel(usuHotelPK pk) {
        this.pk = pk;
    }

    public usuHotelPK getPk() {
        return pk;
    }

    public void setPk(usuHotelPK pk) {
        this.pk = pk;
    }

}
