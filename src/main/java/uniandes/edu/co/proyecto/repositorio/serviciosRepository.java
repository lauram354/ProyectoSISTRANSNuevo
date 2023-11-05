package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicios;

public interface serviciosRepository extends JpaRepository<Servicios, Integer>{

    //RF5
    @Query(value = "select * from servicios", nativeQuery = true)
    Collection<Servicios> darServicios();
    
    @Query(value = "SELECT * FROM servicios WHERE idservicio = :idservicio", nativeQuery = true)
    Servicios darServicio(@Param("idservicio") int idservicio);

    @Modifying
    @Transactional
    @Query(value = "insert into servicios(idservicio, descripcion, costo, tipo_servicio, hoteles_nombre, servicios_type) values (servicios_idservicio_seq.nextval, descripcion = :descripcion, costo = :costo, tipo_servicio = :tiposerv, hoteles_nombre = :hotel, servicios_type = :type)", nativeQuery = true)
    void insertarServicio(@Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("tiposerv") String tiposerv, @Param("hotel") String hotel, @Param("type") String type);

    @Modifying
    @Transactional
    @Query(value = "update servicios set descripcion = :descripcion, costo = :costo, tipo_servicio = :tiposerv, hoteles_nombre = :hotel, servicios_type = :type where idservicio = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") int id, @Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("tiposerv") String tiposerv, @Param("hotel") String hotel, @Param("type") String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE idservicio = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);
} 
