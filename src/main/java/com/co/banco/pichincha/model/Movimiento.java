package com.co.banco.pichincha.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "tipoMovimiento", nullable = false)
    private String tipoMovimiento;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    //bi-directional many-to-one association to Cuenta
    @ManyToOne
    @JoinColumn(name="numerocuenta")
    private Cuenta cuenta;

    public Movimiento(){

    }

    public Movimiento(final Long id, final Date fecha, final String tipoMovimiento, final BigDecimal saldo, final BigDecimal valor, final Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.valor = valor;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(final String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(final BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(final Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}