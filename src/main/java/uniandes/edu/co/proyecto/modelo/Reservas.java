package uniandes.edu.co.proyecto.modelo;

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

    private Integer numpersonas;
    private String fechainicial;
    private String fechafinal;

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

    private boolean check_in;
    private boolean check_out;
    //CONSTRUCTORS
    
    public Reservas()
    {;}

    public Reservas(Integer numpersonas, String fechainicial, String fechafinal,
            boolean check_in, boolean check_out, Planes tipoPlan, Cuentas cuenta, Habis habi, Hoteles nombre) {
        this.numpersonas = numpersonas;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.check_in = check_in;
        this.check_out = check_out;
        this.tipoPlan = tipoPlan;
        this.cuenta = cuenta;
        this.idHabi = habi;
        this.nombreHotel = nombre;
    }

    //GETTERS

    public Integer getIdreserva() {
        return idreserva;
    }

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Habis getIdHabi() {
        return idHabi;
    }

    public void setIdHabi(Habis idHabi) {
        this.idHabi = idHabi;
    }

    public Cuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public Planes getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(Planes tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Integer getNumpersonas() {
        return numpersonas;
    }

    public String getFechainicial() {
        return fechainicial;
    }

    public String getFechafinal() {
        return fechafinal;
    }


    public boolean getCheck_in() {
        return check_in;
    }

    public boolean Check_out() {
        return check_out;
    }
    
    //SETTERS

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public void setNumpersonas(Integer numpersonas) {
        this.numpersonas = numpersonas;
    }

    public void setFechainicial(String fechainicial) {
        this.fechainicial = fechainicial;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public void setCheck_in(boolean check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(boolean check_out) {
        this.check_out = check_out;
    }

}

