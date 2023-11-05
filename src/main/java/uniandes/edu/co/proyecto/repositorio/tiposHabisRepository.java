package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposHabi;

public interface tiposHabisRepository extends JpaRepository<TiposHabi, Integer>{

    //RF3
    @Query(value = "SELECT * FROM tiposhabi", nativeQuery = true)
    Collection<TiposHabi> darTiposHabi();

    @Query(value = "SELECT * FROM tiposhabi WHERE idtipohabi = :idtipohabi", nativeQuery = true)
    TiposHabi darTipoHabi(@Param("idtipohabi") int idtipohabi);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposhabi(idtipohabi,tipo, hoteles_nombre, costo_alojamiento, capacidad) VALUES(TIPOSHABI_IDTIPOHABI_SEQ.nextval, tipo = :tipo, hoteles_nombre = :hotel, costo_alojamiento = :costo, capacidad = :capacidad)", nativeQuery = true)
    void insertarTipoHabi(@Param("tipo") String tipo, @Param("hotel") String hotel, @Param("costo") Float costo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "update tiposhabi set tipo = :tipo, capacidad = :capacidad , costo_alojamiento = :costo where idtipohabi = :idhabi", nativeQuery = true)
    void actualizarTipoHabi(@Param("idhabi") int idhabi, @Param("tipo") String tipo, @Param("capacidad") Integer capacidad, @Param("costo") Float costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposhabi WHERE id = :idhabi", nativeQuery = true)
    void eliminarTipoHabi(@Param("idhabi") int idhabi);
} 

