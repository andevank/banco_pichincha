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
    private String movimiento;

    @NotNull
    private Boolean estado;

    @NotNull
    private Date fecha;

    @NotNull
    private Cuenta cuenta;

    public MovimientoDTO(final Long id, final String movimiento, final Boolean estado, final Date fecha, final Cuenta cuenta) {
        this.id = id;
        this.movimiento = movimiento;
        this.estado = estado;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }
}
