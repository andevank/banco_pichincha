package com.co.banco.pichincha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "genero", nullable = false)
    private String genero;
    @Column(name = "edad", nullable = false)
    private Long edad;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Persona() { }

    public Persona(final Long id, final String nombres, final String genero, final Long edad, final String direccion, final String telefono,final boolean estado) {
        this.id = id;

        this.nombres = nombres;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this. estado = estado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public Long getEdad() {
        return this.edad;
    }

    public void setEdad(final Long edad) {
        this.edad = edad;
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

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(final boolean estado) {
        this.estado = estado;
    }
}