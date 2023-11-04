package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{

    //RF2
    @Query(value = "SELECT * FROM USUARIOS", nativeQuery = true)
    Collection<Usuarios> darUsuarios();
    
    @Query(value = "SELECT * FROM USUARIOS WHERE ID = :id", nativeQuery = true)
    Usuarios darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios (tipo_id, nombre, email, tipousu_idtipo, contrasenia, login) VALUES(:tipo_id, :nombre, :email, :tipoUsu, :contrasenia, :login)", nativeQuery = true)
    void insertarUsuario(@Param("tipo_id") String tipo_id, @Param("nombre") String nombre, @Param("email") String email, @Param("tipoUsu") Integer tipoUsu, @Param("contrasenia") String contrasenia, @Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET tipo_id = :tipo_id, nombre = :nombre, email = :email, tipousu_idtipo = :tipoUsu, contrasenia = :contrasenia, login = :login WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id, @Param("tipo_id") String tipo_id, @Param("nombre") String nombre, @Param("email") String email, @Param("tipoUsu") Integer tipoUsu, @Param("contrasenia") String contrasenia, @Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);
} 
