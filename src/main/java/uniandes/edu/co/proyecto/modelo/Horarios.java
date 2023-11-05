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
@Table(name = "horarios")
public class Horarios{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhorario;
    private String dias;
    private String horaincial;
    private String horafinal;
    private boolean ocupado;

    @ManyToOne
    @JoinColumn(name = "piscina_idservicio", referencedColumnName = "idservicio")
    private Piscina piscina;
    
    @ManyToOne
    @JoinColumn(name = "gym_idservicio", referencedColumnName = "idservicio")
    private Gym gym;

    @ManyToOne
    @JoinColumn(name = "spa_idservicio", referencedColumnName = "idservicio")
    private SPA spa;

    @ManyToOne
    @JoinColumn(name = "salones_idservicio", referencedColumnName = "idservicio")
    private Salones salon;

    public Horarios() {
    }

    public Horarios(Integer idhorario, String dias, String horaincial, String horafinal, boolean ocupado, Piscina piscina, Gym gym, SPA spa, Salones salon) {
        this.idhorario = idhorario;
        this.dias = dias;
        this.horaincial = horaincial;
        this.horafinal = horafinal;
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
        return idhorario;
    }

    public void setIdHorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoraIncial() {
        return horaincial;
    }

    public void setHoraIncial(String horaincial) {
        this.horaincial = horaincial;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}
