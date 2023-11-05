package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.reservaServ;


public interface reservasServRepository extends JpaRepository<reservaServ, Integer>{

    //RF8
    @Query(value = "SELECT * FROM reservaserv", nativeQuery = true)
    Collection<reservaServ> darReservasServ();
    
    @Query(value = "SELECT * FROM reservaserv WHERE idreserva = :id", nativeQuery = true)
    reservaServ darReservaServ(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "insert into reservaserv (idreserva, usuarios_id, consumos_idconsumo, servicios_idservicio) values (reservaserv_idreserva_seq.nextval, usuarios_id = :usuarioid, consumos_idconsumo = :consumo, servicios_idservicio = :idserv)", nativeQuery = true)
    void insertarReservaServ(@Param("usuarioid") Integer usuarioid, @Param("consumo") Integer consumo, @Param("idserv") Integer idserv);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaserv SET usuarios_id = :usuarioid, consumos_idconsumo = :consumo, servicios_idservicio = :idserv WHERE idreserva = :id", nativeQuery = true)
    void actualizarReservaServ(@Param("id") int id, @Param("usuarioid") int usuarioid, @Param("consumo") Integer consumo, @Param("idserv") Integer idserv);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaserv WHERE idreserva = :id", nativeQuery = true)
    void eliminarReservaServ(@Param("id") int id);

} 
