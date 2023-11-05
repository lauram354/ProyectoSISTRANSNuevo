package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Habis;


public interface habisRepository extends JpaRepository<Habis, Integer>{

    //RF4
    @Query(value = "SELECT * FROM HABIS", nativeQuery = true)
    Collection<Habis> darHabis();
    
    @Query(value = "SELECT * FROM HABIS WHERE ID_HABITACION = :id", nativeQuery = true)
    Habis darhabi(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habis(id_habitacion,tv,cafetera, minibar, TiposHabi_idTipoHabi) VALUES(HABIS_ID_HABITACION_SEQ.nextval, tv = :tv, cafetera = :cafetera, minibar = :minibar, TiposHabi_idTipoHabi = :tipohabi)", nativeQuery = true)
    void insertarHabitacion(@Param("tv") Boolean tv, @Param("cafetera") Boolean cafetera, @Param("minibar") Boolean minibar, @Param("tipohabi") Integer tipohabis);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Habis SET tv = :tv ,cafetera = :cafetera, minibar = :minibar, TiposHabi_idTipoHabi = :tipohabi WHERE id_habitacion = :idhabi", nativeQuery = true)
    void actualizarHabitacion(@Param("tv") Boolean tv, @Param("cafetera") Boolean cafetera, @Param("minibar") Boolean minibar, @Param("tipohabi") Integer tipohabis, @Param("idhabi") Integer idhabi);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habis WHERE id_habitacion = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);
} 
