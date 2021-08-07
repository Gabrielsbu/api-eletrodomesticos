package com.electr.eletrodomesticos.domain.utils;


import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EletrodomesticoConverter {

    EletrodomesticoDTO toModelEletrodomestico(Eletrodomestico eletrodomestico);
    List<EletrodomesticoDTO> toCollectionModelEletrodomestico(List<Eletrodomestico> eletrodomesticos);
}
