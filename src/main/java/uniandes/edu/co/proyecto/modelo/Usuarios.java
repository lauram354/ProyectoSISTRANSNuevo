package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipoid;
    private String nombre;
    private String email;
    private String contrasenia;
    private String login;

    @ManyToOne
    @JoinColumn(name = "tiposusu_idtipo", referencedColumnName = "idtipo")
    private tiposUsu tipoUsu;

    public Usuarios()
    {;}

    public Usuarios(Integer id, String tipoId, String nombreUsuario, String email, String login, String contrasenia, tiposUsu tipo) {
        this.id = id;
        this.tipoid = tipoId;
        this.nombre = nombreUsuario;
        this.email = email;
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
        return tipoid;
    }

    public String getNombreUsuario() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }


    //SETTERS

    public void setIdUsuario(Integer idUsuario) {
        this.id = idUsuario;
    }

    public void setTipoId(String tipoId) {
        this.tipoid = tipoId;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

