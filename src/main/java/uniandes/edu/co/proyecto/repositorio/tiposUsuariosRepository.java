package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.tiposUsu;

public interface tiposUsuariosRepository extends JpaRepository<tiposUsu, Integer>{

    //RF1
    @Query(value = "SELECT * FROM tiposusu", nativeQuery = true)
    Collection<tiposUsu> darTiposUsu();

    @Query(value = "SELECT * FROM tiposusu WHERE idtipo = :idtipo", nativeQuery = true)
    tiposUsu darTipoUsuario(@Param("idtipo") int idtipo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposusu (idtipo, tipo) VALUES (tiposusu_idtipo_seq.nextval, tipo = :tipoUsu)", nativeQuery = true)
    void insertarTipoUsuario(@Param("tipoUsu") String tipoUsu);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposusu SET tipoUsu = :tipoUsu WHERE idtipo = :idtipo", nativeQuery = true)
    void actualizarTipoUsuario(@Param("idtipo") int idtipo, @Param("tipoUsu") String tipoUsu);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposusu WHERE tipoUsu = :tipoUsu", nativeQuery = true)
    void eliminarTipoUsuario(@Param("tipoUsu") String tipoUsu);
} 

