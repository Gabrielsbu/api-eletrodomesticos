package com.electr.eletrodomesticos.domain.repositories;

import com.electr.eletrodomesticos.domain.models.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
}