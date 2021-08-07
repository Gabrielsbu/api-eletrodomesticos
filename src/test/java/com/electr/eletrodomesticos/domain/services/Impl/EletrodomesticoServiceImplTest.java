package com.electr.eletrodomesticos.domain.services.Impl;

import com.electr.eletrodomesticos.domain.dto.EletrodomesticoDTO;
import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import com.electr.eletrodomesticos.domain.repositories.EletrodomesticoRepository;
import com.electr.eletrodomesticos.domain.services.AvatarService;
import com.electr.eletrodomesticos.domain.utils.EletrodomesticoConverter;
import com.electr.eletrodomesticos.domain.utils.EletrodomesticoConverterImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
class EletrodomesticoServiceImplTest {
    @InjectMocks
    private EletrodomesticoServiceImpl eletrodomesticoServiceImplMock;

    @Spy
    private EletrodomesticoConverter eletrodomesticoConverterMock = new EletrodomesticoConverterImpl();

    @Mock
    private EletrodomesticoRepository eletrodomesticoRepositoryMock;

    @Mock
    private AvatarService avatarServiceMock;


    @BeforeEach
    void setup(){
        BDDMockito.when(eletrodomesticoRepositoryMock.findAll()).thenReturn(
                Collections.singletonList(createEletrodomestico())
        );

        BDDMockito.when(eletrodomesticoRepositoryMock.save(ArgumentMatchers.any(Eletrodomestico.class))).thenReturn(createEletrodomestico());
    }

    @Test
    void buscarTodosEletrodomesticos_retornaListaDeDados_WhenPossuiDados() {
        List<EletrodomesticoDTO> retorno = this.eletrodomesticoServiceImplMock.buscarTodosEletrodomesticos();

        Assertions.assertThat(retorno).isNotEmpty().isNotNull();
        Assertions.assertThat(retorno).hasOnlyElementsOfType(EletrodomesticoDTO.class);
        retorno.forEach(eletro -> {
            Assertions.assertThat(eletro).isNotNull();
            Assertions.assertThat(eletro.getEletroId()).isNotNull().isExactlyInstanceOf(Long.class);
            Assertions.assertThat(eletro.getAvatar()).isNotNull().isNotEmpty().isExactlyInstanceOf(String.class);
            Assertions.assertThat(eletro.getNome()).isNotNull().isNotEmpty().isExactlyInstanceOf(String.class);
            Assertions.assertThat(eletro.getPotencia()).isNotNull().isExactlyInstanceOf(Integer.class);
        });
    }

    @Test
    void buscarEletrodomesticoPorId() {
    }

    @Test
    void salvarEletrodomestico() {
    }

    @Test
    void atualizarEletrodomestico() {
    }

    @Test
    void deletarEletrodomestico() {
    }

    @Test
    void downloadFile() {
    }

    private Eletrodomestico createEletrodomestico() {
        Eletrodomestico eletrodomestico = new Eletrodomestico();
        eletrodomestico.setNome("Air fry");
        eletrodomestico.setPotencia(220);
        eletrodomestico.setAvatar("nome qualquer do uri");
        eletrodomestico.setEletroId(20L);

        return eletrodomestico;
    }
}