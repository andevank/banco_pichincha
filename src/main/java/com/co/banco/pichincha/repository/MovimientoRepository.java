package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "SELECT" +
            " M.FECHA as FECHA,\n" +
            " P.NOMBRES as NOMBRE_CLIENTE," +
            " CT.NUMEROCUENTA as NUMERO_DE_CUENTA," +
            " CT.TIPOCUENTA as TIPO_CUENTA," +
            " CT.SALDOINICIAL as SALDO_INICIAL," +
            " CT.ESTADO as ESTADO," +
            " M.VALOR as MOVIMIENTO," +
            " M.SALDO as SALDO" +
            " FROM CLIENTE C" +
            " INNER JOIN PERSONA P ON C.PERSONAID  = P.PERSONAID  \n" +
            " INNER JOIN CUENTA  CT ON C.CLIENTEID = CT.CLIENTEID \n" +
            " INNER JOIN MOVIMIENTO M ON M.NUMERO_CUENTA = CT.NUMEROCUENTA" +
            " WHERE C.CLIENTEID=: clienteid ", nativeQuery = true)
    Optional<Movimiento> getReporteFechaUsuario(@Param("clienteid") Long clienteid);
}
