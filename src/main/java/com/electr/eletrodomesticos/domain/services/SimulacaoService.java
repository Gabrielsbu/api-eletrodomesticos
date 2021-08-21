package com.electr.eletrodomesticos.domain.services;

import com.electr.eletrodomesticos.domain.dto.CreateSimulacaoDTO;
import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.dto.SimulacaoDTO;
import com.electr.eletrodomesticos.domain.models.Simulacao;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface SimulacaoService {

    SimulacaoDTO procurarSimulacaoPorId(Long simulacaoId);

    SimulacaoDTO salvarSimulacao(CreateSimulacaoDTO simulacao);

    List<SimulacaoDTO> procurarSimulacoes();



}
