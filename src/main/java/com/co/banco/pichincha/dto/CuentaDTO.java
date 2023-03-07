package com.co.banco.pichincha.dto;

import com.co.banco.pichincha.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Getter
@Setter
public class CuentaDTO {

    @Id
    private Long id;

    @NotNull
    private Long numerocuenta;

    @NotNull
    private String tipocuenta;
    @NotNull
    private BigDecimal saldoinicial;

    @NotNull
    private Boolean estado;

    @NotNull
    private Cliente cliente;

    public CuentaDTO(final Long id, final Long numerocuenta, final String tipocuenta, final BigDecimal saldoinicial, final Boolean estado, final Cliente cliente) {
        this.id = id;
        this.numerocuenta = numerocuenta;
        this.tipocuenta = tipocuenta;
        this.saldoinicial = saldoinicial;
        this.estado = estado;
        this.cliente = cliente;
    }
}
