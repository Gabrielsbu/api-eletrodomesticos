package com.electr.eletrodomesticos.domain.repositories;

import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Eletro Repistory")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EletrodomesticoRepositoryTest {

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @Test
    @DisplayName("Save creates Eletrodomestico when Successful")
    void save_PersistEltrodomestico_WhenSuccessful() {
        Eletrodomestico eletrodomestico = createEletrodomestico();
        Eletrodomestico eletrodomesticoSaved = this.eletrodomesticoRepository.save(eletrodomestico);

        Assertions.assertThat(eletrodomesticoSaved).isNotNull();
        Assertions.assertThat(eletrodomesticoSaved.getEletroId()).isNotNull();
        Assertions.assertThat(eletrodomesticoSaved.getNome()).isEqualTo(eletrodomesticoSaved.getNome()).isNotNull();
    }

    @Test
    @DisplayName("Deleted Eletrodomestico when Successful")
    void delete_DeletedEltrodomestico_WhenSuccessful() {
        Eletrodomestico eletrodomestico = createEletrodomestico();
        Eletrodomestico eletrodomesticoSaved = this.eletrodomesticoRepository.save(eletrodomestico);

        this.eletrodomesticoRepository.deleteById(eletrodomesticoSaved.getEletroId());

        Optional<Eletrodomestico> eletrodomesticoNotDeleted = this.eletrodomesticoRepository.findById(eletrodomesticoSaved.getEletroId());
        Assertions.assertThat(eletrodomesticoNotDeleted.isPresent()).isFalse();
    }

    @Test
    @DisplayName("Search Eletrodomestico by id when Successful")
    void findById_ReturnEletrodomestico_whenSuccessful(){
        Eletrodomestico eletrodomestico = createEletrodomestico();
        Eletrodomestico eletrodomesticoSaved = this.eletrodomesticoRepository.save(eletrodomestico);

        Optional<Eletrodomestico> eletrodomesticoSearch = this.eletrodomesticoRepository.findById(eletrodomesticoSaved.getEletroId());

        Assertions.assertThat(eletrodomesticoSearch.isPresent()).isTrue();
        Assertions.assertThat(eletrodomesticoSearch.get()).isExactlyInstanceOf(Eletrodomestico.class);
        Assertions.assertThat(eletrodomesticoSearch.get().getNome()).isEqualTo(eletrodomesticoSaved.getNome());

        Assertions.assertThatThrownBy(() -> this.eletrodomesticoRepository.save(eletrodomestico)).isInstanceOf(HttpClientErrorException.BadRequest.class);
    }

    private Eletrodomestico createEletrodomestico() {
        Eletrodomestico eletrodomestico = new Eletrodomestico();
        eletrodomestico.setNome("Air fry");
        eletrodomestico.setPotencia(220);
        eletrodomestico.setAvatar("nome qualquer do uri");

        return eletrodomestico;
    }

}