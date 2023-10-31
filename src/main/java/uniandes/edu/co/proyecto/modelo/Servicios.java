package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer idServicio;

    private String tipo_servicio;
    private String descripcion;
    private float costo;
    private String idTipo;

    @ManyToOne
    @JoinColumn(name = "Clientes_id", referencedColumnName = "id")
    private Clientes idCliente;

    @ManyToOne
    @JoinColumn(name = "Cuentas_idCuenta", referencedColumnName = "idCuenta")
    private Cuentas idCuenta;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles hotel;

    //CONSTRUCTORS

    public Servicios()
    {;}

    public Servicios(String tipo, String descripcion, float costo, Clientes idCliente, Cuentas idCuenta, String idTipo, Hoteles hotel) {
        this.tipo_servicio = tipo;
        this.descripcion =descripcion;
        this.costo = costo;
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
        this.idTipo = idTipo;
        this.hotel = hotel;
    }

    //GETTERS

    public Hoteles getHotel() {
        return hotel;
    }

    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Cuentas getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuentas idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public String getTipo() {
        return tipo_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }
    //SETTERS
   
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public void setTipo(String tipo) {
        this.tipo_servicio = tipo;
    }
    
}
