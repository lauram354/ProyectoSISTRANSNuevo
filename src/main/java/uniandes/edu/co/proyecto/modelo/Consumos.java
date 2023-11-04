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
@Table(name = "consumos")
public class Consumos{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idconsumo;
    private Boolean pagado;
    private Float costofinal;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cuentas_idcuenta", referencedColumnName = "idcuenta")
    private Cuentas iducuenta;

    @ManyToOne
    @JoinColumn(name = "habis_id_habitacion", referencedColumnName = "id_habitacion")
    private Habis id_habitacion;


    //CONSTRUCTORS

    public Consumos()
    {;}


    public Consumos(Integer idconsumo, Boolean pagado, Float costofinal, Date fecha, Cuentas iducuenta,
            Habis id_habitacion) {
        this.idconsumo = idconsumo;
        this.pagado = pagado;
        this.costofinal = costofinal;
        this.fecha = fecha;
        this.iducuenta = iducuenta;
        this.id_habitacion = id_habitacion;
    }


    public Integer getIdconsumo() {
        return idconsumo;
    }


    public void setIdconsumo(Integer idconsumo) {
        this.idconsumo = idconsumo;
    }


    public Boolean getPagado() {
        return pagado;
    }


    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }


    public Float getCostofinal() {
        return costofinal;
    }


    public void setCostofinal(Float costofinal) {
        this.costofinal = costofinal;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Cuentas getIducuenta() {
        return iducuenta;
    }


    public void setIducuenta(Cuentas iducuenta) {
        this.iducuenta = iducuenta;
    }


    public Habis getId_habitacion() {
        return id_habitacion;
    }


    public void setId_habitacion(Habis id_habitacion) {
        this.id_habitacion = id_habitacion;
    }


  
}

