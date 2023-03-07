package com.co.banco.pichincha.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero_cuenta", nullable = false)
    private Long numerocuenta;

    @Column(name = "tipocuenta", nullable = false)
    private String tipocuenta;

    @Column(name = "saldoinicial", nullable = false)
    private BigDecimal saldoinicial;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    //bi-directional many-to-one association to Cliente
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="clienteid")
    private Cliente cliente;

    //bi-directional many-to-one association to Movimiento
    @JsonIgnore
    @OneToMany(mappedBy="cuenta")
    private List<Movimiento> movimientos;

    public Cuenta(){

    }
    public Cuenta(final Long id, final Long numerocuenta, final String tipocuenta, final BigDecimal saldoinicial, final Boolean estado, final Cliente cliente) {
        this.id = id;
        this.numerocuenta = numerocuenta;
        this.tipocuenta = tipocuenta;
        this.saldoinicial = saldoinicial;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getNumerocuenta() {
        return this.numerocuenta;
    }

    public void setNumerocuenta(final Long numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(final Boolean estado) {
        this.estado = estado;
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

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Movimiento> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(final List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}