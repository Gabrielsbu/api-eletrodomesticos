package com.electr.eletrodomesticos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoFullDTO {

    private Long eletroId;
    private String avatar;
    private Integer quantidade;
    private String nome;
    private Integer tempoEmHora;
    private Integer potencia;
    private Integer diasPorMes;

    private Double valorPorMes;
    private Double kwhPorMes;
    private LocalDateTime createEletrodomesticoAt;
    private LocalDateTime updateEletrodomesticoAt;
}
