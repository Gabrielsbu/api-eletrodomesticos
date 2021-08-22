package com.electr.eletrodomesticos.domain.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "eletrodomesticos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eletroId;
    private String avatar;
    private String nome;
    private Integer quantidade;
    private Integer tempoEmHora;
    private Integer potencia;
    private Integer diasPorMes;

    @ManyToOne
    @JoinColumn(name = "simulacao_id")
    private Simulacao simulacao;

    @Column(precision=10, scale=2)
    private Double valorPorMes;

    @Column(precision=10, scale=2)
    private Double kwhPorMes;

    private LocalDateTime createEletrodomesticoAt;
    private LocalDateTime updateEletrodomesticoAt;

    @PrePersist
    public void prePersist(){
        this.createEletrodomesticoAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateEletrodomesticoAt = LocalDateTime.now();
    }
}