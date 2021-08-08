package com.electr.eletrodomesticos.domain.services.Impl;

import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import com.electr.eletrodomesticos.domain.repositories.EletrodomesticoRepository;
import com.electr.eletrodomesticos.domain.services.AvatarService;
import com.electr.eletrodomesticos.domain.services.EletrodomesticoService;

import com.electr.eletrodomesticos.domain.utils.EletrodomesticoConverter;
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
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EletrodomesticoServiceImpl implements EletrodomesticoService {

    private final EletrodomesticoRepository eletrodomesticoRepository;
    private final EletrodomesticoConverter eletrodomesticoConverter;
    private final AvatarService avatarService;

    @Override
    public List<EletrodomesticoDTO> buscarTodosEletrodomesticos(){
        List<EletrodomesticoDTO> usuarios = eletrodomesticoConverter.toCollectionModelEletrodomestico(eletrodomesticoRepository.findAll());

        if(usuarios.isEmpty()){
            throw new AllException("A lista de eletrodomésticos se encontra vazia", HttpStatus.NO_CONTENT);
        }

        return usuarios;
    }

    @Override
    public EletrodomesticoDTO buscarEletrodomesticoPorId(Long eletroId){
        return eletrodomesticoConverter.toModelEletrodomestico(eletrodomesticoRepository.findById(eletroId)
                .orElseThrow(() -> new AllException("Eletrodoméstico não encontrado", HttpStatus.NOT_FOUND)));
    }

    @Override
    public EletrodomesticoDTO salvarEletrodomestico(MultipartFile avatar, String nome, Integer potencia, Integer tempo, Integer quantidade, Integer diasPorMes){

        String fileDownloadUri = avatarService.createImageInServer(avatar);

        Double valorPorMesEmW = calcularConsumoAparelho(potencia, diasPorMes, tempo);


        Eletrodomestico eletrodomestico = Eletrodomestico.builder()
                .setNome(nome)
                .setPotencia(potencia)
                .setQuantidade(quantidade)
                .setTempo(tempo)
                .setAvatar(fileDownloadUri)
                .setDiasPorMes(diasPorMes)
                .setValorPorMes(valorPorMesEmW)
                .build();

        return eletrodomesticoConverter.toModelEletrodomestico(eletrodomesticoRepository.save(eletrodomestico));
    }

    private Double calcularConsumoAparelho(Integer potencia, Integer diasPorMes, Integer tempo){

        Long horas = (long) (tempo / 60);

        final double valorKw = 0.84;

        return ((potencia * horas * diasPorMes)/1000) * valorKw;
    }

    @Override
    public EletrodomesticoDTO atualizarEletrodomestico(Long eletroId, String nome, Integer potencia, MultipartFile avatar){
        String fileDownloadUri = avatarService.createImageInServer(avatar);

        Eletrodomestico eletrodomesticoExistente = eletrodomesticoRepository.findById(eletroId)
                .orElseThrow(() -> new AllException("Eletrodoméstico não encontrado", HttpStatus.NOT_FOUND));

        if(nome != null) {
            eletrodomesticoExistente.setNome(nome);
        }

        if(potencia != null) {
            eletrodomesticoExistente.setPotencia(potencia);
        }

        if(avatar != null) {
            eletrodomesticoExistente.setAvatar(fileDownloadUri);
        }

        return eletrodomesticoConverter.toModelEletrodomestico(eletrodomesticoRepository.save(eletrodomesticoExistente));
    }

    @Override
    public ResponseEntity<Void> deletarEletrodomestico(Long eletroId){

        EletrodomesticoDTO usuario = buscarEletrodomesticoPorId(eletroId);

        if( usuario == null ) {
            throw new AllException("Não existe eletrodoméstico com este identificador");
        }

        eletrodomesticoRepository.deleteById(eletroId);

        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<Resource> downloadFile(String title, HttpServletRequest request) {
        Resource resource = avatarService.loadPicture(title);

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            throw new AllException("Não encontramos esta imagem");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
