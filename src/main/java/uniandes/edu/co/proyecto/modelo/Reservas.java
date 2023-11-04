package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreserva;

    private Integer cant_personas;
    private Date  fecha_entrada;
    private Date fecha_salida;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles nombreHotel;

    @ManyToOne
    @JoinColumn(name = "planes_tipo_plan", referencedColumnName = "tipo_plan")
    private Planes tipoPlan;

    @ManyToOne
    @JoinColumn(name = "cuentas_idcuenta", referencedColumnName = "idcuenta")
    private Cuentas cuenta;

    @ManyToOne
    @JoinColumn(name = "habis_id_habitacion", referencedColumnName = "id_habitacion")
    private Habis idHabi;


    //CONSTRUCTORS
    
    public Reservas()
    {;}


    public Reservas(Integer idreserva, Integer cant_personas, Date fecha_entrada, Date fecha_salida,
            Hoteles nombreHotel, Planes tipoPlan, Cuentas cuenta, Habis idHabi) {
        this.idreserva = idreserva;
        this.cant_personas = cant_personas;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.nombreHotel = nombreHotel;
        this.tipoPlan = tipoPlan;
        this.cuenta = cuenta;
        this.idHabi = idHabi;
    }


    public Integer getIdreserva() {
        return idreserva;
    }


    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }


    public Integer getCant_personas() {
        return cant_personas;
    }


    public void setCant_personas(Integer cant_personas) {
        this.cant_personas = cant_personas;
    }


    public Date getFecha_entrada() {
        return fecha_entrada;
    }


    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }


    public Date getFecha_salida() {
        return fecha_salida;
    }


    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }


    public Hoteles getNombreHotel() {
        return nombreHotel;
    }


    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }


    public Planes getTipoPlan() {
        return tipoPlan;
    }


    public void setTipoPlan(Planes tipoPlan) {
        this.tipoPlan = tipoPlan;
    }


    public Cuentas getCuenta() {
        return cuenta;
    }


    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }


    public Habis getIdHabi() {
        return idHabi;
    }


    public void setIdHabi(Habis idHabi) {
        this.idHabi = idHabi;
    }



 
   

}

