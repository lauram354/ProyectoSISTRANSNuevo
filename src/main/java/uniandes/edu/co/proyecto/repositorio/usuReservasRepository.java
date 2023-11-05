package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.usuReservas;


public interface usuReservasRepository extends JpaRepository<usuReservas, Integer>{

    //RF9 y RF11
    @Query(value = "SELECT * FROM usuReservas", nativeQuery = true)
    Collection<usuReservas> darUsuReservas();

    @Query(value = "SELECT * FROM usuReservas WHERE usuarios_id = :id", nativeQuery = true)
    usuReservas darUsuReserva(@Param("id") int id);
    
    @Query(value = "SELECT checkin FROM usuReservas WHERE usuarios_id = :idusuario and reservas_idreserva = :idreserva", nativeQuery = true)
    Collection<usuReservas> darCheckIn(@Param("idusuario") int idusuario, @Param("idreserva") int idreserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuReservas SET checkin = :checkin  where usuarios_id = :idusuario and reservas_idreserva = :idreserva", nativeQuery = true)
    void actualizarCheckIn(@Param("idusuario") int idusuario, @Param("checkin") Boolean checkin, @Param("idreserva") int idreserva);

    @Query(value = "SELECT checkout FROM usuReservas WHERE usuarios_id = :idusuario and reservas_idreserva = :idreserva", nativeQuery = true)
    Collection<usuReservas> darCheckOut(@Param("idusuario") int idusuario, @Param("idreserva") int idreserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuReservas SET checkout = :checkout  where usuarios_id = :idusuario and reservas_idreserva = :idreserva", nativeQuery = true)
    void actualizarCheckOut(@Param("idusuario") int idusuario, @Param("checkout") Boolean checkout, @Param("idreserva") int idreserva);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuReservas WHERE usuarios_id = :idusuario and reservas_idreserva = :idreserva", nativeQuery = true)
    void eliminarUsuReservas(@Param("idusuario") int idusuario, @Param("idreserva") int idreserva);
} 
