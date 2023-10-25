package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "Piscina_idServicio", referencedColumnName = "idServicio")
    private Piscina piscina;
    
    @ManyToOne
    @JoinColumn(name = "Gym_idServicio", referencedColumnName = "idServicio")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "SPA_idServicio", referencedColumnName = "idServicio")
    private SPA spa;

    @ManyToOne
    @JoinColumn(name = "Salones_idServicio", referencedColumnName = "idServicio")
    private Salones salon;

    public Horarios() {
    }

    public Horarios(Integer idHorario, String dias, Date horaIncial, Date horaFinal, boolean ocupado, Piscina piscina, Gym gym, SPA spa, Salones salon) {
        this.idHorario = idHorario;
        this.dias = dias;
        this.horaIncial = horaIncial;
        this.horaFinal = horaFinal;
        this.ocupado = ocupado;
        this.piscina = piscina;
        this.gym = gym;
        this.spa = spa;
        this.salon = salon;
    }

    public Piscina getPiscina() {
        return piscina;
    }

    public void setPiscina(Piscina piscina) {
        this.piscina = piscina;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public SPA getSpa() {
        return spa;
    }

    public void setSpa(SPA spa) {
        this.spa = spa;
    }

    public Salones getSalon() {
        return salon;
    }

    public void setSalon(Salones salon) {
        this.salon = salon;
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
