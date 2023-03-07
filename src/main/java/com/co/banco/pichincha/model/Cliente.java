package com.co.banco.pichincha.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteid", nullable = false)
    private Long clienteid;

    @Column(name = "contrasena", nullable = false)
    private Integer contrasena;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    //bi-directional many-to-one association to Persona
    @ManyToOne
    @JoinColumn(name="personaid")
    private Persona persona;

    //bi-directional many-to-one association to Cuenta
    @OneToMany(mappedBy="cliente")
    private List<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(final Long clienteid, final Integer contrasena, final Boolean estado, final Persona persona) {
        this.clienteid = clienteid;
        this.contrasena = contrasena;
        this.estado = estado;
        this.persona = persona;
    }

    public Long getClienteId() {
        return this.clienteid;
    }

    public void setClienteId(final Long id) {
        clienteid = id;
    }

    public Long getClienteid() {
        return this.clienteid;
    }

    public void setClienteid(final Long clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(final Integer contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(final Boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(final Persona persona) {
        this.persona = persona;
    }

    public List<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(final List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}