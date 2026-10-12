package br.com.fiap.EcoTrack.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PONTO_COLETA")
public class PontoColeta {

    @Id
    @Column(name = "ID_PONTO")
    private Long idPonto;

    @Column(name = "LOCAL", nullable = false, length = 100)
    private String local;

    @Column(name = "CAPACIDADE_MAX", columnDefinition = "NUMBER")
    private Double capacidadeMax;
}