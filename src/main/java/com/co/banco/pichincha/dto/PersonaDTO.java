package com.co.banco.pichincha.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
public class PersonaDTO {
    @Id
    private Long id;
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

    public PersonaDTO(final Long id, final String nombres, final String genero, final Long edad, final String direccion, final String telefono, final boolean estado) {
        this.id = id;
        this.nombres = nombres;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public PersonaDTO(){}
}
