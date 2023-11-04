package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usureservas")
public class usuReservas {

    @EmbeddedId
    private usuReservasPK pk;
    private Boolean checkin;
    private Boolean checkout;


    public usuReservas() {
    }

    public usuReservas(usuReservasPK pk, Boolean checkin, Boolean checkout) {
        this.pk = pk;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public usuReservasPK getPk() {
        return pk;
    }

    public void setPk(usuReservasPK pk) {
        this.pk = pk;
    }

    public Boolean getCheckin() {
        return checkin;
    }

    public void setCheckin(Boolean checkin) {
        this.checkin = checkin;
    }

    public Boolean getCheckout() {
        return checkout;
    }

    public void setCheckout(Boolean checkout) {
        this.checkout = checkout;
    }

    

}
