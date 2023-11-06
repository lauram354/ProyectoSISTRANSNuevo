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

    @Query(value = "select unique servicios_type from servicios", nativeQuery = true)
    List<Object[]> darTiposServicios();
    
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

     @Query(value = "SELECT * FROM servicios " +
     "INNER JOIN reservaserv ON servicios.idservicio = reservaserv.servicios_idservicio " +
     "INNER JOIN consumos ON reservaserv.consumos_idconsumo = consumos.idconsumo " +
     "WHERE reservaserv.usuarios_id = :usuarioId " +
     "AND consumos.fecha BETWEEN :fechaInicio AND :fechaFin " +
     "AND servicios.tipo_servicio = :tipoServicio",
     nativeQuery = true)
     List<Object[]> obtenerServiciosPorCaracteristica(@Param("usuarioId") String usuarioId, @Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("tipoServicio") String tipoServicio);
        
        @Query(value = "SELECT servicios.tipo_servicio, COUNT(servicios.tipo_servicio)/52 AS SERVICIO_POR_SEMANA " +
        "FROM reservaserv " +
        "INNER JOIN servicios ON reservaserv.servicios_idservicio = servicios.idservicio " +
        "GROUP BY servicios.tipo_servicio " +
        "HAVING COUNT(servicios.tipo_servicio)/52 < 3", nativeQuery = true)
        List<Object[]> encontrarServiciosConPocaDemanda();


        @Query(value = "SELECT * FROM servicios " +
        "INNER JOIN reservaserv ON servicios.idservicio = reservaserv.servicios_idservicio " +
        "INNER JOIN consumos ON reservaserv.consumos_idconsumo = consumos.idconsumo " ,nativeQuery = true)
        List<Object[]> obtenerServiciosConsumo();
        
        


     
} 
