package br.com.fiap.EcoTrack.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESIDUO")
public class Residuo {

    @Id
    @Column(name = "ID_RESIDUO")
    private Long idResiduo;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "LIMITE_MAX", columnDefinition = "NUMBER")
    private Double limiteMax;
}