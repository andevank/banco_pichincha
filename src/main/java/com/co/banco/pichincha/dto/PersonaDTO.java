package com.co.banco.pichincha.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
public class PersonaDTO {
    private Long id;
    @Id
    private String personaid;
    @NotNull
    private String nombres;

    @NotNull
    private String genero;
    @NotNull
    private Long edad;

    @NotNull
    private String direccion;
    @NotNull
    private String telefono;

    @NotNull
    private boolean estado;

    public PersonaDTO(final Long id, final String personaid, final String nombres, final String genero, final Long edad, final String direccion, final String telefono, final boolean estado) {
        this.id = id;
        this.personaid = personaid;
        this.nombres = nombres;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public PersonaDTO(){}
}
