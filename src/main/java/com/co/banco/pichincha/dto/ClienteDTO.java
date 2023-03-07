package com.co.banco.pichincha.dto;

import com.co.banco.pichincha.model.Persona;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
public class ClienteDTO {

   @Id
    private Long clienteid;
    @NotNull
    private Integer contrasena;
    @NotNull
    private Boolean estado;
    @NotNull
    private Persona idpersona;

    public ClienteDTO(final Long clienteid, final Integer contrasena, final Boolean estado, final Persona persona) {
        this.clienteid = clienteid;
        this.contrasena = contrasena;
        this.estado = estado;
        this.idpersona = persona;
    }

}
