package br.com.fiap.EcoTrack.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "REGISTRO_DESCARTE")
public class RegistroDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_descarte")
    @SequenceGenerator(name = "seq_descarte", sequenceName = "SEQ_DESCARTE", allocationSize = 1)
    @Column(name = "ID_DESCARTE")
    private Long idDescarte;

    @ManyToOne
    @JoinColumn(name = "ID_RESIDUO", nullable = false)
    private Residuo residuo;

    @ManyToOne
    @JoinColumn(name = "ID_PONTO", nullable = false)
    private PontoColeta pontoColeta;

    @Column(name = "QUANTIDADE", columnDefinition = "NUMBER")
    private Double quantidade;

    @Column(name = "DATA_DESCARTE")
    private LocalDate dataDescarte = LocalDate.now();
}