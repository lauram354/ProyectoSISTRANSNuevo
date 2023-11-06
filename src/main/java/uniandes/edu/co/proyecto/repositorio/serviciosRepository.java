package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

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
    void actualizarServicio(@Param("id") int id, @Param("descripcion") String descripcion, @Param("costo") Float costo, @Param("tiposerv") String tiposerv, @Param("hotel") String hotel, @Param("type") String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE idservicio = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);

    @Query(value = "SELECT h.id_habitacion, SUM(c.costoFinal) " +
    "FROM habis h " +
    "INNER JOIN consumos c ON h.id_habitacion = c.habis_id_habitacion " +
    "WHERE c.fecha BETWEEN '01/01/2023' AND '31/12/2023' " +
    "GROUP BY h.id_habitacion", nativeQuery = true)
     List<Object[]> calcularDineroRecolectadoPorHabitacionEnUltimoAnio();

     @Query(value = "select servicios.tipo_servicio, count(servicios.tipo_servicio) AS Consumo " + 
             "from Servicios inner join reservaserv on servicios.idservicio = reservaServ.Servicios_idServicio " + 
             "inner join consumos on reservaserv.consumos_idconsumo = consumos.idconsumo " + 
             "where consumos.fecha between :fechaInicial and :fechaFinal AND rownum < 21 " + 
             "group by servicios.tipo_servicio " + 
             "ORDER BY COUNT(servicios.tipo_servicio) DESC", nativeQuery = true)
     List<Object[]> top20Servicios(String fechaInicial, String fechaFinal);

     
} 
