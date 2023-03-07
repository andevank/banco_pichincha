package com.co.banco.pichincha.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idpersona")
    private Persona idpersona;

    //bi-directional many-to-one association to Cuenta
    @JsonIgnore
    @OneToMany(mappedBy="cliente")
    private List<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(final Long clienteid, final Integer contrasena, final Boolean estado, final Persona persona) {
        this.clienteid = clienteid;
        this.contrasena = contrasena;
        this.estado = estado;
        this.idpersona = persona;
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

    public Persona getIdpersona() {
        return this.idpersona;
    }

    public void setIdpersona(final Persona idpersona) {
        this.idpersona = idpersona;
    }

    public List<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(final List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}