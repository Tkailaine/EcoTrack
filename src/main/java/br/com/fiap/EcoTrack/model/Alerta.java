package br.com.fiap.EcoTrack.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alerta")
    @SequenceGenerator(name = "seq_alerta", sequenceName = "SEQ_ALERTA", allocationSize = 1)
    @Column(name = "ID_ALERTA")
    private Long idAlerta;

    @Column(name = "MENSAGEM", length = 200)
    private String mensagem;

    @Column(name = "DATA_ALERTA")
    private LocalDate dataAlerta;

    @Column(name = "TIPO_ALERTA", length = 50)
    private String tipoAlerta;
}