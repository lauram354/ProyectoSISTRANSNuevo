package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    //CONSTRUCTORS

    public Servicios()
    {;}

    public Servicios(String tipo, String descripcion, float costo) {
        this.tipo_servicio = tipo;
        this.descripcion =descripcion;
        this.costo = costo;
    }

    //GETTERS

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
