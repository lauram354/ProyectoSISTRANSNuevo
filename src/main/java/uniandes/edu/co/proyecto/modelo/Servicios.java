package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idservicio;

    private String tipo_servicio;
    private String descripcion;
    private float costo;
    private String servicios_type;

  

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hoteles hotel;

    // CONSTRUCTORS

    public Servicios() {
        ;
    }

    public Servicios(String tipo, String descripcion, float costo, String servicios_type, Hoteles hotel) {
        this.tipo_servicio = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.servicios_type = servicios_type;
        this.hotel = hotel;
    }

    // GETTERS

    public Hoteles getHotel() {
        return hotel;
    }

    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }

    public String getservicios_type() {
        return servicios_type;
    }

    public void setservicios_type(String servicios_type) {
        this.servicios_type = servicios_type;
    }


    public Integer getIdservicio() {
        return idservicio;
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
    // SETTERS

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public void setTipo(String tipo) {
        this.tipo_servicio = tipo;
    }

}
