package com.electr.eletrodomesticos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarEletrodomesticoDTO {

    private String nome;
    private Integer potencia;
    private String avatar;
}
