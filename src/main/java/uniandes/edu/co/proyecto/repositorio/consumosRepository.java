package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

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

    //RFC5
    @Query(value= "SELECT USUARIOS.ID, USUARIOS.NOMBRE, RESERVASERV.IDRESERVA, SERVICIOS.SERVICIOS_TYPE, CONSUMOS.COSTOFINAL, CONSUMOS.FECHA " + 
            "FROM USUARIOS INNER JOIN RESERVASERV ON reservaserv.usuarios_id = usuarios.id " + 
            "INNER JOIN CONSUMOS ON reservaserv.consumos_idconsumo = consumos.idconsumo " + 
            "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " , nativeQuery = true)
    List<Object[]>  darConsumosReq5();

    @Query(value= "SELECT USUARIOS.ID, USUARIOS.NOMBRE, RESERVASERV.IDRESERVA, SERVICIOS.SERVICIOS_TYPE, CONSUMOS.COSTOFINAL, CONSUMOS.FECHA " + 
            "FROM USUARIOS INNER JOIN RESERVASERV ON reservaserv.usuarios_id = usuarios.id " + 
            "INNER JOIN CONSUMOS ON reservaserv.consumos_idconsumo = consumos.idconsumo " + 
            "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " + 
            "WHERE USUARIOS.ID = :id AND CONSUMOS.FECHA between :fechaInicial and :fechaFinal", nativeQuery = true)
    List<Object[]>  darConsumosPorFechas(@Param("id") String id, @Param("fechaInicial") String fechaInicial, @Param("fechaFinal") String fechaFinal);

    //RFC9
    @Query(value = "SELECT USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, CONSUMOS.FECHA, SERVICIOS.SERVICIOS_TYPE " +
    "FROM USUARIOS " +
    "INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID " +
    "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " +
    "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO " +
    "WHERE CONSUMOS.FECHA BETWEEN '01/01/2020' AND '31/12/2024' " +
    "AND SERVICIOS.TIPO_SERVICIO = 'INTERNET' " +
    "ORDER BY USUARIOS.ID",
    nativeQuery = true)
    List<Object[]> consultarConsumoInternet();
    
    @Query(value = "SELECT USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, SERVICIOS.SERVICIOS_TYPE, COUNT(SERVICIOS.SERVICIOS_TYPE) " +
    "FROM USUARIOS " +
    "INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID " +
    "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " +
    "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO " +
    "WHERE CONSUMOS.FECHA BETWEEN '01/01/2020' AND '31/12/2024' " +
    "AND SERVICIOS.TIPO_SERVICIO = 'INTERNET' " +
    "GROUP BY USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, SERVICIOS.SERVICIOS_TYPE " +
    "HAVING COUNT(SERVICIOS.SERVICIOS_TYPE) < 3",
    nativeQuery = true)
    List<Object[]> consultarConsumoInternetCount();

    @Query(value = "SELECT USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, CONSUMOS.FECHA, SERVICIOS.SERVICIOS_TYPE " +
    "FROM USUARIOS " +
    "INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID " +
    "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " +
    "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO " +
    "WHERE CONSUMOS.FECHA BETWEEN :fechainicio AND :fechafin " +
    "AND SERVICIOS.TIPO_SERVICIO = :tipo " +
    "ORDER BY USUARIOS.ID",
    nativeQuery = true)
    List<Object[]> consultarConsumoCaracteristica(@Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin, @Param("tipo") String tiposervicio);
    
    @Query(value = "SELECT USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, SERVICIOS.SERVICIOS_TYPE, COUNT(SERVICIOS.SERVICIOS_TYPE) " +
    "FROM USUARIOS " +
    "INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID " +
    "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO " +
    "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO " +
    "WHERE CONSUMOS.FECHA BETWEEN :fechainicio AND :fechafin " +
    "AND SERVICIOS.TIPO_SERVICIO = :tipo " +
    "GROUP BY USUARIOS.ID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, SERVICIOS.SERVICIOS_TYPE" ,
    nativeQuery = true)
    List<Object[]> consultarConsumoCaracteristicaCount(@Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin, @Param("tipo") String tiposervicio);

    //RFC7

    @Query(value = "SELECT usuarios.id, SUM(consumos.costofinal) as consumos " +
    "FROM reservas " +
    "INNER JOIN usureservas ON reservas.idreserva = usureservas.reservas_idreserva " +
    "INNER JOIN usuarios ON usureservas.usuarios_id = usuarios.id " +
    "FULL JOIN reservaserv ON usuarios.id = reservaserv.usuarios_id " +
    "FULL JOIN consumos ON reservaserv.consumos_idconsumo = consumos.idconsumo " +
    "WHERE (TO_CHAR(reservas.fecha_salida, 'IW') - TO_CHAR(reservas.fecha_entrada, 'IW') > 2) " +
    "GROUP BY usuarios.id " +
    "HAVING SUM(consumos.costofinal) > 15000000", nativeQuery = true)
    List<Object[]> encontrarBuenosClientes();

    //RFC10
        // Consulta SQL 1: Obtener los consumos en el rango de fechas especificado sin PISCINA
        @Query(value = "SELECT USUARIOS.ID, USUARIOS.TIPOID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, CONSUMOS.FECHA, SERVICIOS.SERVICIOS_TYPE "
        + "FROM USUARIOS INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID "
        + "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO "
        + "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO "
        + "WHERE CONSUMOS.FECHA BETWEEN :fechaInicio AND :fechaFin AND SERVICIOS.TIPO_SERVICIO != :tiposervicio "
        + "ORDER BY USUARIOS.ID", nativeQuery = true)
        List<Object[]> darConsumos(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("tiposervicio") String tiposervicio);

        // Consulta SQL 2: Obtener la cantidad de consumos agrupados por usuarios y tipo de servicio
        @Query(value = "SELECT USUARIOS.ID, USUARIOS.TIPOID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, SERVICIOS.SERVICIOS_TYPE, COUNT(SERVICIOS.SERVICIOS_TYPE) "
        + "FROM USUARIOS INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID "
        + "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO "
        + "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO "
        + "WHERE CONSUMOS.FECHA BETWEEN :fechaInicio AND :fechaFin AND SERVICIOS.TIPO_SERVICIO != :tiposervicio "
        + "GROUP BY USUARIOS.ID, USUARIOS.TIPOID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, SERVICIOS.SERVICIOS_TYPE", nativeQuery = true)
        List<Object[]> darConsumosCount(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("tiposervicio") String tiposervicio);

        @Query(value = "SELECT USUARIOS.ID, USUARIOS.TIPOID, USUARIOS.NOMBRE, USUARIOS.EMAIL, USUARIOS.LOGIN, CONSUMOS.FECHA, SERVICIOS.SERVICIOS_TYPE "
        + "FROM USUARIOS INNER JOIN RESERVASERV ON RESERVASERV.USUARIOS_ID = USUARIOS.ID "
        + "INNER JOIN SERVICIOS ON RESERVASERV.SERVICIOS_IDSERVICIO = SERVICIOS.IDSERVICIO "
        + "INNER JOIN CONSUMOS ON RESERVASERV.CONSUMOS_IDCONSUMO = CONSUMOS.IDCONSUMO "
        + "ORDER BY USUARIOS.ID", nativeQuery = true)
        List<Object[]> darConsumosDefault();
} 
