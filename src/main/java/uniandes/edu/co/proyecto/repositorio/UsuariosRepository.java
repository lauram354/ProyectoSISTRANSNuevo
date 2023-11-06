package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

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

    @Query(value = "SELECT * FROM USUARIOS WHERE login = :login", nativeQuery = true)
    Usuarios darUsuarioLogin(@Param("login") String login);

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
    
    @Query(value = "SELECT DISTINCT usuario, nombre " + 
            "FROM ( " + 
            "SELECT usuario, NOMBRE " + 
            "FROM ( " + 
            "SELECT UNIQUE USURESERVAS.USUARIOS_ID AS usuario, U.NOMBRE AS NOMBRE, " + 
            "TO_CHAR(RESERVAS.FECHA_ENTRADA, 'Q') AS trimestre " + 
            "FROM USURESERVAS " + 
            "INNER JOIN RESERVAS ON reservas.idreserva = usureservas.reservas_idreserva " + 
            "INNER JOIN USUARIOS U ON U.ID = USURESERVAS.USUARIOS_ID " + 
            "WHERE U.TIPOSUSU_IDTIPO = 2) " +
            "GROUP BY usuario, NOMBRE " + 
            "HAVING SUM(trimestre) = 10 " + 
            "UNION ALL " + 
            "SELECT u.id AS usuario, u.nombre " + 
            "FROM  USUARIOS U INNER JOIN USURESERVAS US ON U.ID = US.USUARIOS_ID " + 
            "INNER JOIN RESERVASERV  RE ON RE.USUARIOS_ID = U.ID " + 
            "INNER JOIN CONSUMOS C ON RE.CONSUMOS_IDCONSUMO = C.IDCONSUMO " + 
            "INNER JOIN SERVICIOS S ON RE.SERVICIOS_IDSERVICIO = S.IDSERVICIO " + 
            "WHERE C.COSTOFINAL > 300000 AND U.TIPOSUSU_IDTIPO = 2 " + 
            "UNION ALL " + 
            "SELECT U.ID AS usuario, u.nombre " + 
            "FROM  USUARIOS U INNER JOIN RESERVASERV  RE ON RE.USUARIOS_ID = U.ID " + 
            "INNER JOIN SERVICIOS S ON RE.SERVICIOS_IDSERVICIO = S.IDSERVICIO " + 
            "FULL JOIN SPA ON S.IDSERVICIO = SPA.IDSERVICIO " + 
            "FULL JOIN SALONES ON S.IDSERVICIO = SALONES.IDSERVICIO " + 
            "WHERE SPA.DURACION > 4 OR SALONES.HORAS > 4 AND U.TIPOSUSU_IDTIPO = 2 " + 
            ") req12", nativeQuery = true)
    List<Object[]> encontrarClientesExcelentes();
} 
