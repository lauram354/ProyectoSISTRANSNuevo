package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Habis")
public class Habis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_habitacion;
    private Boolean tv;
    private Boolean miniBar;
    private Boolean cafetera;

    @ManyToOne
    @JoinColumn(name = "TiposHabi_idTipoHabi", referencedColumnName = "idTipoHabi")
    private TiposHabi tipo;


    
    //CONSTRUCTORS

    public Habis()
    {;}

    public Habis(Boolean tv, Boolean miniBar, Boolean cafetera, TiposHabi tipo) {
        this.tv = tv;
        this.miniBar = miniBar;
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

    public Boolean getMiniBar() {
        return miniBar;
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

    public void setMiniBar(Boolean miniBar) {
        this.miniBar = miniBar;
    }

    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }

    
    
    
    
}
