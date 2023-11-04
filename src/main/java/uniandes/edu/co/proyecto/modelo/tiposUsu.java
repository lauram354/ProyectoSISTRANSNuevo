package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposusu")
public class tiposUsu {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtipo;
    private String tipo;

    
    public tiposUsu() {
    }


    public tiposUsu(Integer idTipo, String tipo) {
        this.idtipo = idTipo;
        this.tipo = tipo;
    }


    public Integer getIdTipo() {
        return idtipo;
    }


    public void setIdTipo(Integer idTipo) {
        this.idtipo = idTipo;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    
}
