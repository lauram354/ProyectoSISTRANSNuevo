package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuentas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idcuenta;
    private Boolean pagado;
    private Date fecha;
    //CONSTRUCTORS

    public Cuentas()
    {;}

    public Cuentas(Boolean pagado, Date fecha) {
        this.pagado = pagado;
        this.fecha = fecha;
    }

    //GETTERS

    public Integer getIdCuenta() {
        return idcuenta;
    }

    public Boolean getPagado() {
        return pagado;
    }


    public Date getFecha() {
        return fecha;
    }

    
    //SETTERS

    public void setIdCuenta(Integer idCuenta) {
        this.idcuenta = idCuenta;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
