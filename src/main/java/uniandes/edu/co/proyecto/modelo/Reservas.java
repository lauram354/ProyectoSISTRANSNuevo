package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;

    private Integer numPersonas;
    private String fechaInicial;
    private String fechaFinal;

    @ManyToOne
    @JoinColumn(name = "Planes_tipo_plan", referencedColumnName = "tipo_plan")
    private Planes tipoPlan;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta", referencedColumnName = "idCuenta")
    private Cuentas cuenta;

    @ManyToOne
    @JoinColumn(name = "Habis_id_habitacion", referencedColumnName = "id_habitacion")
    private Habis idHabi;

    private boolean check_in;
    private boolean check_out;
    //CONSTRUCTORS
    
    public Reservas()
    {;}

    public Reservas(Integer numPersonas, String fechaInicial, String fechaFinal,
            boolean check_in, boolean check_out, Planes tipoPlan, Cuentas cuenta, Habis habi) {
        this.numPersonas = numPersonas;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.check_in = check_in;
        this.check_out = check_out;
        this.tipoPlan = tipoPlan;
        this.cuenta = cuenta;
        this.idHabi = habi;
    }

    //GETTERS

    public Integer getIdReserva() {
        return idReserva;
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

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }


    public boolean getCheck_in() {
        return check_in;
    }

    public boolean Check_out() {
        return check_out;
    }
    
    //SETTERS

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setCheck_in(boolean check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(boolean check_out) {
        this.check_out = check_out;
    }

}

