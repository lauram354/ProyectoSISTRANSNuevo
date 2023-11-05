package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumos;


public interface consumosRepository extends JpaRepository<Consumos, Integer>{

    //RF10
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumos> darConsumos();
    
    @Query(value = "SELECT * FROM consumos WHERE idconsumo = :id", nativeQuery = true)
    Consumos darConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "insert into consumos (idconsumo, pagado, costofinal, cuentas_idcuenta, fecha, habis_id_habitacion) values (consumos_idconsumo_seq.nextval, pagado = :pagado, costofinal = :costofinal, cuentas_idcuenta = :idcuenta, fecha = :fecha, habis_id_habitacion = :habi)", nativeQuery = true)
    void insertarConsumo(@Param("pagado") Boolean pagado, @Param("costofinal") Float costofinal, @Param("idcuenta") Integer idcuenta, @Param("fecha") Date fecha, @Param("habi") int habi);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET pagado = :pagado, costofinal = :costofinal, cuentas_idcuenta = :idcuenta, fecha = :fecha, habis_id_habitacion = :habi WHERE idconsumo = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id") int id, @Param("pagado") Boolean pagado, @Param("costofinal") Float costofinal, @Param("idcuenta") Integer idcuenta, @Param("fecha") Date fecha, @Param("habi") int habi);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE idconsumo = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") int id);
} 
