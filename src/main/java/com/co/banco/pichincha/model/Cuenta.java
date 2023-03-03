package com.co.banco.pichincha.model;

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

    private Long numerocuenta;

    private Boolean estado;

    private BigDecimal saldoinicial;

    private String tipocuenta;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name="clienteid")
    private Cliente cliente;

    //bi-directional many-to-one association to Movimiento
    @OneToMany(mappedBy="cuenta")
    private List<Movimiento> movimientos;


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