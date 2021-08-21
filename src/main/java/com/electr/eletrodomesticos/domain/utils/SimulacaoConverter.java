package com.electr.eletrodomesticos.domain.utils;


import com.electr.eletrodomesticos.domain.dto.CreateSimulacaoDTO;
import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.dto.SimulacaoDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import com.electr.eletrodomesticos.domain.models.Simulacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimulacaoConverter {

    Simulacao toEletrodomestico(CreateSimulacaoDTO simulacao);
    List<SimulacaoDTO> toCollectionDTO(List<Simulacao> simulacoes);
    SimulacaoDTO toDTO(Simulacao simulacao);
}
