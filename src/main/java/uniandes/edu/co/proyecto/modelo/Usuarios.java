package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String contrasenia;
    private String login;

    @ManyToOne
    @JoinColumn(name = "tiposUsu_idTipo", referencedColumnName = "idTipo")
    private tiposUsu tipoUsu;

    public Usuarios()
    {;}

    public Usuarios(Integer id, String tipoId, String nombreUsuario, String email, String login, String contrasenia, tiposUsu tipo) {
        this.id = id;
        this.tipo_id = tipoId;
        this.nombre = nombreUsuario;
        this.eMail = email;
        this.contrasenia = contrasenia;
        this.login = login;
        this.tipoUsu = tipo;
    }

    //GETTERS

    public Integer getIdUsuario() {
        return id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public tiposUsu getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(tiposUsu tipoUsu) {
        this.tipoUsu = tipoUsu;
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

}

