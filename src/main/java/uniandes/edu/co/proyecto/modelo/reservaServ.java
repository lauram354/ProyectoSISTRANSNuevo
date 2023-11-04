package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaserv")
public class reservaServ{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreserva;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuarios idusuario;



    @ManyToOne
    @JoinColumn(name = "servicios_idservicio", referencedColumnName = "idservicio")
    private Servicios idservicio;

    @ManyToOne
    @JoinColumn(name = "consumos_idconsumo", referencedColumnName = "idconsumo")
    private Consumos consumo;


    //CONSTRUCTORS
    
    public reservaServ(Integer idreserva, Usuarios idusuario, Servicios idservicio, Consumos consumo) {
        this.idreserva = idreserva;
        this.idusuario = idusuario;
        this.idservicio = idservicio;
        this.consumo = consumo;
    }


    public Integer getIdreserva() {
        return idreserva;
    }


    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }


    public Usuarios getIdusuario() {
        return idusuario;
    }


    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }


    public Servicios getIdservicio() {
        return idservicio;
    }


    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
    }


    public Consumos getConsumo() {
        return consumo;
    }


    public void setConsumo(Consumos consumo) {
        this.consumo = consumo;
    }


    public reservaServ()
    {;}


  
}

