package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    
    //CONSTRUCTORS

    public Habis()
    {;}

    public Habis(Boolean tv, Boolean miniBar, Boolean cafetera) {
        this.tv = tv;
        this.miniBar = miniBar;
        this.cafetera = cafetera;
    }
    //GETTERS
    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public Boolean getTv() {
        return tv;
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
