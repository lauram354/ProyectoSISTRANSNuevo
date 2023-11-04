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
    private Float valor;
    //CONSTRUCTORS

    public Cuentas()
    {;}

    public Cuentas(Integer idcuenta, Float valor) {
        this.idcuenta = idcuenta;
        this.valor = valor;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


    

}
