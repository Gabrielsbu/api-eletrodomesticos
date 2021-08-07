package com.electr.eletrodomesticos.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "eletrodomesticos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eletroId;
    private String nome;
    private Integer potencia;
    private String avatar;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
