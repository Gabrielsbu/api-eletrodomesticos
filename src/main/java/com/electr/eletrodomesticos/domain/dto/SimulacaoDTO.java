package com.electr.eletrodomesticos.domain.dto;

import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import com.electr.eletrodomesticos.domain.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimulacaoDTO {

    private Long simulacaoId;
    private List<EletrodomesticoDTO> eletrodomesticos = new ArrayList<>();

    private float totalValorPorMes;
    private float totalKwhPorMes;

    private LocalDateTime createSimulationAt;
    private LocalDateTime updateSimulationAt;
}
