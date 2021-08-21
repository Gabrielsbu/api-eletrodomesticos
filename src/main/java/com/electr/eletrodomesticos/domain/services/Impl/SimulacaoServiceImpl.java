package com.electr.eletrodomesticos.domain.services.Impl;

import com.electr.eletrodomesticos.domain.dto.CreateSimulacaoDTO;
import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.dto.SimulacaoDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import com.electr.eletrodomesticos.domain.models.Simulacao;
import com.electr.eletrodomesticos.domain.models.Usuario;
import com.electr.eletrodomesticos.domain.repositories.EletrodomesticoRepository;
import com.electr.eletrodomesticos.domain.repositories.SimulacaoRepository;
import com.electr.eletrodomesticos.domain.repositories.UsuarioRepository;
import com.electr.eletrodomesticos.domain.services.AvatarService;
import com.electr.eletrodomesticos.domain.services.EletrodomesticoService;
import com.electr.eletrodomesticos.domain.services.SimulacaoService;
import com.electr.eletrodomesticos.domain.utils.EletrodomesticoConverter;
import com.electr.eletrodomesticos.domain.utils.SimulacaoConverter;
import com.electr.eletrodomesticos.exceptions.AllException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimulacaoServiceImpl implements SimulacaoService {

    private final SimulacaoRepository simulacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final SimulacaoConverter simulacaoConverter;
    private final EletrodomesticoConverter eletrodomesticoConverter;

    @Override
    public SimulacaoDTO procurarSimulacaoPorId(Long simulacaoId){
        return simulacaoConverter.toDTO(simulacaoRepository.findById(simulacaoId)
                .orElseThrow(() -> new AllException("Simulação não encontrada")));
    }

    @Override
    public SimulacaoDTO salvarSimulacao(CreateSimulacaoDTO simulacao) {
        Simulacao createSimulacao = new Simulacao();

        List<EletrodomesticoDTO> eletrodomesticos = new ArrayList<>();

        simulacao.getEletrodomesticos().forEach(eletrodomestico -> {

            eletrodomestico.setKwhPorMes(calcularKWh(eletrodomestico).getKwhPorMes());
            eletrodomestico.setValorPorMes(calcularKWh(eletrodomestico).getValorPorMes());
            eletrodomesticos.add(eletrodomestico);

            double totalKwhPorMes = 0.0;
            totalKwhPorMes = totalKwhPorMes + eletrodomestico.getKwhPorMes();

            double totalPorMes = 0.0;
            totalPorMes = eletrodomestico.getValorPorMes() + totalPorMes;

            createSimulacao.setTotalKwhPorMes(totalKwhPorMes);
            createSimulacao.setTotalValorPorMes(totalPorMes);
        });

        createSimulacao.setEletrodomesticos(eletrodomesticoConverter.toCollectionDTO(eletrodomesticos));

        Usuario usuario = usuarioRepository.findById(simulacao.getUsuarioId()).
                orElseThrow(() -> new AllException("Usuário não encontrado"));

        createSimulacao.setUsuario(usuario);

        simulacaoRepository.save(createSimulacao);

        return simulacaoConverter.toDTO(createSimulacao);
    }

    private EletrodomesticoDTO calcularKWh(EletrodomesticoDTO eletrodomesticoDTO){
         Long hora = (long) (eletrodomesticoDTO.getTempoEmMinuto() / 60);
         long kWhPorMes = 30 * eletrodomesticoDTO.getPotencia() * hora * eletrodomesticoDTO.getQuantidade();
         eletrodomesticoDTO.setKwhPorMes((double) kWhPorMes);
         eletrodomesticoDTO.setValorPorMes(kWhPorMes * 0.84);
         return eletrodomesticoDTO;
    }

    @Override
    public List<SimulacaoDTO> procurarSimulacoes() {
        return simulacaoConverter.toCollectionDTO(simulacaoRepository.findAll());
    }
}
