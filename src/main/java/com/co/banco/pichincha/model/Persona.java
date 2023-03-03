package com.co.banco.pichincha.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "personaid", nullable = false)
    @NotNull
    private String personaid;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    // bi-directional many-to-one association to Cliente
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Cliente> clientes;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPersonaid() {
        return this.personaid;
    }

    public void setPersonaid(final String personaid) {
        this.personaid = personaid;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(final Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(final List<Cliente> clientes) {
        this.clientes = clientes;
    }
}