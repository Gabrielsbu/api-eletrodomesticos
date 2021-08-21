package com.electr.eletrodomesticos.domain.repositories;

import com.electr.eletrodomesticos.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}