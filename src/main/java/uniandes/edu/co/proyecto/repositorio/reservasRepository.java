package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Reservas;


public interface reservasRepository extends JpaRepository<Reservas, Integer>{

    //RF7
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reservas> darReservas();
    
    @Query(value = "SELECT * FROM reservas WHERE idreserva = :id", nativeQuery = true)
    Reservas darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "insert into reservas (idreserva, fecha_entrada, fecha_salida, cant_personas, habis_id_habitacion, cuentas_idcuenta, planes_idtipoplan, hoteles_nombre) values (reservas_idreserva_seq.nextval, fecha_entrada = :fechaentrada, fecha_salida = :fechasalida, cant_personas = :cant, habias_id_habitacion = :habi, cuentas_idcuenta = :cuenta, planes_idtipoplan = :plan, hoteles_nombre = :hotel)", nativeQuery = true)
    void insertarReserva(@Param("fechaentrada") Date fechaentrada, @Param("fechasalida") Date fechasalida, @Param("cant") Integer cant, @Param("habi") Integer habi, @Param("cuenta") Integer cuenta, @Param("plan") int plan,  @Param("hotel") String hotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fecha_entrada = :fechaentrada, fecha_salida = :fechasalida, cant_personas = :cant, habias_id_habitacion = :habi, cuentas_idcuenta = :cuenta, planes_idtipoplan = :plan, hoteles_nombre = :hotel WHERE idreserva = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("fechaentrada") Date fechaentrada, @Param("fechasalida") Date fechasalida, @Param("cant") Integer cant, @Param("habi") Integer habi, @Param("cuenta") Integer cuenta, @Param("plan") int plan,  @Param("hotel") String hotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE idreserva = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    

    @Query(value = "SELECT RESERVAS.HABIS_ID_HABITACION, COUNT(RESERVAS.HABIS_ID_HABITACION)*100/(SELECT COUNT(*) FROM RESERVAS WHERE FECHA_ENTRADA between '01/01/2023' and '31/12/2023') AS PorcentajeOcupacion " +
            "FROM RESERVAS " +
            "WHERE FECHA_ENTRADA between '01/01/2023' and '31/12/2023' " +
            "GROUP BY HABIS_ID_HABITACION", nativeQuery = true)
     List<Object[]> indiceOcupacionHabitaciones();

     //RFC6 parte 1
     @Query(value= "WITH fechas_reservas AS (SELECT fecha_entrada AS fecha FROM reservas " + 
             "UNION ALL " + 
             "SELECT fecha_salida FROM reservas), " +
             "dias_intermedios AS ( " + 
             "SELECT " + 
             "fecha_entrada + LEVEL - 1 AS fecha " + 
             "FROM (SELECT MIN(fecha) AS fecha_entrada, MAX(fecha) AS fecha_salida FROM fechas_reservas) " + 
             "CONNECT BY LEVEL <= fecha_salida - fecha_entrada + 1) " + 
             "SELECT di.fecha, COUNT(idreserva) AS habitaciones_ocupadas " + 
             "FROM dias_intermedios di LEFT JOIN reservas r ON di.fecha BETWEEN r.fecha_entrada AND r.fecha_salida " + 
             "GROUP BY di.fecha " + 
             "ORDER BY COUNT(idreserva) DESC " + 
             "FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
    List<Object[]>  darFechaMayorOcupacion();

    //RFC6 parte 2
     @Query(value= "WITH fechas_reservas AS (SELECT fecha_entrada AS fecha FROM reservas " + 
             "UNION ALL " + 
             "SELECT fecha_salida FROM reservas), " +
             "dias_intermedios AS ( " + 
             "SELECT " + 
             "fecha_entrada + LEVEL - 1 AS fecha " + 
             "FROM (SELECT MIN(fecha) AS fecha_entrada, MAX(fecha) AS fecha_salida FROM fechas_reservas) " + 
             "CONNECT BY LEVEL <= fecha_salida - fecha_entrada + 1) " + 
             "SELECT di.fecha, COUNT(idreserva) AS habitaciones_ocupadas " + 
             "FROM dias_intermedios di LEFT JOIN reservas r ON di.fecha BETWEEN r.fecha_entrada AND r.fecha_salida " + 
             "GROUP BY di.fecha " + 
             "ORDER BY COUNT(idreserva) ASC " + 
             "FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
    List<Object[]>  darFechaMenorOcupacion();

    //RFC6 parte 2
     @Query(value= "SELECT FECHA, SUM(consumos.costofinal) " + 
             "FROM CONSUMOS " +
             "GROUP BY FECHA " + 
             "ORDER BY  SUM(consumos.costofinal) DESC " + 
             "FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
    List<Object[]>  darFechaMayorConsumo();

    
} 
