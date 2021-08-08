package com.electr.eletrodomesticos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoDTO {

    private Long eletroId;
    private String nome;
    private Integer tempo;
    private Integer quantidade;
    private Integer potencia;
    private Integer diasPorMes;
    private String avatar;
    private Double valorPorMes;
}
