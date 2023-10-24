package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Horarios")
public class Horarios{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHorario;
    private String dias;
    private Date horaIncial;
    private Date horaFinal;
    private boolean ocupado;
    
    public Horarios() {
    }

    public Horarios(Integer idHorario, String dias, Date horaIncial, Date horaFinal, boolean ocupado) {
        this.idHorario = idHorario;
        this.dias = dias;
        this.horaIncial = horaIncial;
        this.horaFinal = horaFinal;
        this.ocupado = ocupado;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Date getHoraIncial() {
        return horaIncial;
    }

    public void setHoraIncial(Date horaIncial) {
        this.horaIncial = horaIncial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}
