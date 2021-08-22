package com.electr.eletrodomesticos.domain.utils;


import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.dto.EletrodomesticoFullDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EletrodomesticoConverter {

    EletrodomesticoDTO toModelEletrodomestico(Eletrodomestico eletrodomestico);

    EletrodomesticoFullDTO toEletrodomesticoDTO(Eletrodomestico eletrodomestico);

    Eletrodomestico toEletrodomesticoFull(EletrodomesticoFullDTO eletrodomesticoFullDTO);

    List<EletrodomesticoDTO> toCollectionModelEletrodomestico(List<Eletrodomestico> eletrodomesticos);

    List<EletrodomesticoFullDTO> toCollectionModelEletrodomesticoFull(List<Eletrodomestico> eletrodomesticos);
}
