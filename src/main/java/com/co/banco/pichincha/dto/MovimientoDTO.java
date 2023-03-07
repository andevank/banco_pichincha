package com.co.banco.pichincha.dto;

import com.co.banco.pichincha.model.Cuenta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class MovimientoDTO {

    @Id
    private Long id;

    @NotNull
    private Date fecha;

    @NotNull
    private String tipoMovimiento;

    @NotNull
    private BigDecimal saldo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Cuenta cuenta;

    public MovimientoDTO(final Long id, final Date fecha, final String tipoMovimiento, final BigDecimal saldo, final BigDecimal valor, final Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.valor = valor;
        this.cuenta = cuenta;
    }
}
