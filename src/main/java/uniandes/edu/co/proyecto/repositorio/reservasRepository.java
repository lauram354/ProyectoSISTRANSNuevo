package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

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
    
} 
