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
    private String nome;
    private Integer potencia;
    private Integer tempo;
    private Integer quantidade;
    private Integer diasPorMes;

    @Column(name="valor_por_mes", columnDefinition="Decimal(10,2)")
    private Double valorPorMes;

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
