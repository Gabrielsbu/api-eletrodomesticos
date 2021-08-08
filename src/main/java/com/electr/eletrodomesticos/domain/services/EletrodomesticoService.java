package com.electr.eletrodomesticos.domain.services;

import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface EletrodomesticoService {

    List<EletrodomesticoDTO> buscarTodosEletrodomesticos();

    EletrodomesticoDTO buscarEletrodomesticoPorId(Long eletroId);

    EletrodomesticoDTO salvarEletrodomestico(MultipartFile avatar, String nome, Integer potencia, Integer tempo, Integer quantidade, Integer diasPorMes);

    EletrodomesticoDTO atualizarEletrodomestico(Long eletroId, String nome, Integer potencia, MultipartFile avatar);

    ResponseEntity<Void> deletarEletrodomestico(Long eletroId);

    ResponseEntity<Resource> downloadFile(@PathVariable String title, HttpServletRequest request);
}
