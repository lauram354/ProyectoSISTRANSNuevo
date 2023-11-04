package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habis")
public class Habis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_habitacion;
    private Boolean tv;
    private Boolean minibar;
    private Boolean cafetera;

    @ManyToOne
    @JoinColumn(name = "tiposhabi_idtipohabi", referencedColumnName = "idtipohabi")
    private TiposHabi tipo;
 

    
    //CONSTRUCTORS

    public Habis()
    {;}

    public Habis(Boolean tv, Boolean minibar, Boolean cafetera, TiposHabi tipo) {
        this.tv = tv;
        this.minibar = minibar;
        this.cafetera = cafetera;
        this.tipo = tipo;
    }
    //GETTERS
    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public Boolean getTv() {
        return tv;
    }

    public TiposHabi getTipo() {
        return tipo;
    }

    public void setTipo(TiposHabi tipo) {
        this.tipo = tipo;
    }

    public Boolean getMinibar() {
        return minibar;
    }

    public Boolean getCafetera() {
        return cafetera;
    }

    //SETTERS
    
    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public void setMinibar(Boolean minibar) {
        this.minibar = minibar;
    }

    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }


    
}
