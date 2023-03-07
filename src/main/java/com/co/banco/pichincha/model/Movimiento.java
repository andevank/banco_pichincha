package com.co.banco.pichincha.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "movimiento", nullable = false)
    private String movimiento;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    //bi-directional many-to-one association to Cuenta
    @ManyToOne
    @JoinColumn(name="numero_cuenta")
    private Cuenta cuenta;

    public Movimiento(){

    }

    public Movimiento(final Long id, final String movimiento, final Boolean estado, final Date fecha, final Cuenta cuenta) {
        this.id = id;
        this.movimiento = movimiento;
        this.estado = estado;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMovimiento() {
        return this.movimiento;
    }

    public void setMovimiento(final String movimiento) {
        this.movimiento = movimiento;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(final Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(final Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}