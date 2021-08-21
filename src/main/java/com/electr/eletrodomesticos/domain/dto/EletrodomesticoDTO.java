package com.electr.eletrodomesticos.domain.dto;

import com.electr.eletrodomesticos.domain.models.Simulacao;
import com.electr.eletrodomesticos.domain.models.Usuario;
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
    private String avatar;
    private String nome;
    private Integer quantidade;
    private Integer tempoEmMinuto;
    private Integer potencia;

    private Double valorPorMes;
    private Double kwhPorMes;
}
