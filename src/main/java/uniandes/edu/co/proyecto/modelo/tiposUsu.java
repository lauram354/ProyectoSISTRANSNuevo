package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposUsu")
public class tiposUsu {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idTipo;
    private String tipo;

    
    public tiposUsu() {
    }


    public tiposUsu(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }


    public Integer getIdTipo() {
        return idTipo;
    }


    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    
}
