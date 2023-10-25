package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo_id;
    private String nombre;
    private String eMail;
    private String rol;


    public Usuarios()
    {;}

    public Usuarios(Integer id, String tipoId, String nombreUsuario, String email, String rol) {
        this.id = id;
        this.tipo_id = tipoId;
        this.nombre = nombreUsuario;
        this.eMail = email;
        this.rol = rol;
    }

    //GETTERS

    public Integer getIdUsuario() {
        return id;
    }

    public String getTipoId() {
        return tipo_id;
    }

    public String getNombreUsuario() {
        return nombre;
    }

    public String getEmail() {
        return eMail;
    }

    public String getRol() {
        return rol;
    }


    //SETTERS

    public void setIdUsuario(Integer idUsuario) {
        this.id = idUsuario;
    }

    public void setTipoId(String tipoId) {
        this.tipo_id = tipoId;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre = nombreUsuario;
    }

    public void setEmail(String email) {
        this.eMail = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}

