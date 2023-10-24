package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Salones")
public class Salones {

    @EmbeddedId
    private SalonesPK pk;

    private Float horas;
    private String tipo;
    private float horarioAdicional;


    public Salones()
    {;}


    public Salones(SalonesPK pk, Float horas, String tipo, float horarioAdicional) {
        this.pk = pk;
        this.horas = horas;
        this.tipo = tipo;
        this.horarioAdicional = horarioAdicional;
    }


    public SalonesPK getPk() {
        return pk;
    }


    public Float getHoras() {
        return horas;
    }


    public String getTipo() {
        return tipo;
    }


    public float getHorarioAdicional() {
        return horarioAdicional;
    }


    public void setPk(SalonesPK pk) {
        this.pk = pk;
    }


    public void setHoras(Float horas) {
        this.horas = horas;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void setHorarioAdicional(float horarioAdicional) {
        this.horarioAdicional = horarioAdicional;
    }

    

}
