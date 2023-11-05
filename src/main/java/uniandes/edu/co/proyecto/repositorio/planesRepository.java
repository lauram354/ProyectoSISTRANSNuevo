package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Planes;
import uniandes.edu.co.proyecto.modelo.Usuarios;

public interface planesRepository extends JpaRepository<Planes, Integer>{

    //RF6
    @Query(value = "SELECT * FROM planes", nativeQuery = true)
    Collection<Planes> darPlanes();

    @Query(value = "SELECT * FROM planes WHERE idtipoplan = :id", nativeQuery = true)
    Planes darPlan(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Planes( idTipoPlan,tipo_plan,descuento,Hoteles_nombre) VALUES(PLANES_IDTIPOPLAN_SEQ.nextval, tipo_plan = :tipoPlan, descuento = :descuento, Hoteles_nombre = :hotel)" , nativeQuery = true)
    void insertarPlanes(@Param("tipoPlan") String tipoPlan, @Param("descuento") Float descuento, @Param("hotel") String hotel);

    @Modifying
    @Transactional
    @Query(value = "update planes set tipo_plan = :tipoPlan, descuento = :descuento WHERE idtipoplan = :idplan", nativeQuery = true)
    void actualizarPlan(@Param("tipoPlan") String tipoPlan, @Param("descuento") Float descuento, @Param("idplan") Integer idplan);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes WHERE idtipoplan = :idplan", nativeQuery = true)
    void eliminarPlan(@Param("idplan") Integer idplan);
} 

