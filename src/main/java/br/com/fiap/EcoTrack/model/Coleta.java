package br.com.fiap.EcoTrack.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "COLETA")
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_coleta")
    @SequenceGenerator(name = "seq_coleta", sequenceName = "SEQ_COLETA", allocationSize = 1)
    @Column(name = "ID_COLETA")
    private Long idColeta;

    @ManyToOne
    @JoinColumn(name = "ID_PONTO", nullable = false)
    private PontoColeta pontoColeta;

    @Column(name = "DATA_COLETA")
    private LocalDate dataColeta;

    @Column(name = "STATUS", length = 20)
    private String status; // PENDENTE ou REALIZADA
}

