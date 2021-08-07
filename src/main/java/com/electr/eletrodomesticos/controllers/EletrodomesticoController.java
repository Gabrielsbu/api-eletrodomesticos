package com.electr.eletrodomesticos.controllers;

import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.services.EletrodomesticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/eletrodomesticos")
@RestController
@RequiredArgsConstructor
public class EletrodomesticoController {

    private final EletrodomesticoService eletrodomesticoService;

    @GetMapping
    public List<EletrodomesticoDTO> buscarTodosEletrodomesticos() {
        return eletrodomesticoService.buscarTodosEletrodomesticos();
    }

    @GetMapping("/{eletroId}")
    public EletrodomesticoDTO buscarEletrodomesticoPorId(@PathVariable Long eletroId){
        return eletrodomesticoService.buscarEletrodomesticoPorId(eletroId);
    }

    @PostMapping
    public EletrodomesticoDTO salvarEletrodomestico(@RequestParam("nome") String nome,
                                    @RequestParam("potencia") Integer potencia,
                                    @RequestParam("avatar") MultipartFile avatar){

        return eletrodomesticoService.salvarEletrodomestico(nome, potencia, avatar);
    }

    @PutMapping("/{eletroId}")
    public EletrodomesticoDTO atualizarEletrodomestico(@PathVariable Long eletroId, @RequestParam("nome") String nome,
                                                       @RequestParam("potencia") Integer potencia,
                                                       @RequestParam("avatar") MultipartFile avatar) {

        return eletrodomesticoService.atualizarEletrodomestico(eletroId, nome, potencia, avatar);
    }

    @DeleteMapping("/{eletroId}")
    public ResponseEntity<Void> deletarEletrodomestico(@PathVariable Long eletroId){
        return eletrodomesticoService.deletarEletrodomestico(eletroId);
    }

    @GetMapping("/search-picture/{title:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String title, HttpServletRequest request) {
        return eletrodomesticoService.downloadFile(title, request);
    }
}
