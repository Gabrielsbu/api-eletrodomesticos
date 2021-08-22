package com.electr.eletrodomesticos.domain.dto;

import com.electr.eletrodomesticos.domain.models.Simulacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoDTO {

    private Long eletroId;
    private String nome;
    private Integer quantidade;
    private Integer tempoEmHora;
    private Integer potencia;
    private Integer diasPorMes;
    private float valorPorMes;
    private float kwhPorMes;

}
