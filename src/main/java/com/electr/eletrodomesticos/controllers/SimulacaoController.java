package com.electr.eletrodomesticos.controllers;

import com.electr.eletrodomesticos.domain.dto.CreateSimulacaoDTO;
import com.electr.eletrodomesticos.domain.dto.SimulacaoDTO;
import com.electr.eletrodomesticos.domain.models.Simulacao;
import com.electr.eletrodomesticos.domain.services.SimulacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/simulacao")
@RestController
@RequiredArgsConstructor
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    @GetMapping("/{simulacaoId}")
    public SimulacaoDTO buscarSimulacaoPorId(@PathVariable Long simulacaoId) {
        return simulacaoService.procurarSimulacaoPorId(simulacaoId);
    }

    @GetMapping
    public List<SimulacaoDTO> buscarTodasSimulacoes() {
        return simulacaoService.procurarSimulacoes();
    }

    @PostMapping
    public SimulacaoDTO cadastrarSimulacao(@RequestBody CreateSimulacaoDTO simulacao){
        return simulacaoService.salvarSimulacao(simulacao);
    }
}
