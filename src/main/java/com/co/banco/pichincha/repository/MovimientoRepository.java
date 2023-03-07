package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "SELECT M.FECHA,P.NOMBRES,CT.NUMERO_CUENTA, CT.TIPOCUENTA,CT.SALDOINICIAL,CT.ESTADO,M.VALOR,M.SALDO FROM CLIENTE C INNER JOIN PERSONA P ON C.PERSONAID = P.PERSONAID INNER JOIN CUENTA CT ON C.CLIENTEID = CT.CLIENTEID INNER JOIN MOVIMIENTO M ON M.NUMERO_CUENTA = CT.NUMERO_CUENTA", nativeQuery = true)
    Optional<Movimiento> getReporteFechaUsuario(@Param("clienteid") Long clienteid);
}
