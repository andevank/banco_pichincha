package com.co.banco.pichincha.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Boolean estado;

    private String movimiento;

    private BigDecimal saldoinicial;

    private String tipocuenta;

    //bi-directional many-to-one association to Cuenta
    @ManyToOne
    @JoinColumn(name="numerocuenta")
    private Cuenta cuenta;


    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(final Boolean estado) {
        this.estado = estado;
    }

    public String getMovimiento() {
        return this.movimiento;
    }

    public void setMovimiento(final String movimiento) {
        this.movimiento = movimiento;
    }

    public BigDecimal getSaldoinicial() {
        return this.saldoinicial;
    }

    public void setSaldoinicial(final BigDecimal saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public String getTipocuenta() {
        return this.tipocuenta;
    }

    public void setTipocuenta(final String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(final Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}