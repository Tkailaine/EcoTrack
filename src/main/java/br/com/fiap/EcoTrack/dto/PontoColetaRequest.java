package br.com.fiap.EcoTrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PontoColetaRequest {

    @NotNull(message = "O ID do ponto é obrigatório.")
    private Long idPonto;

    @NotBlank(message = "O local não pode estar em branco.")
    private String local;

    @NotNull(message = "A capacidade máxima é obrigatória.")
    @Positive(message = "A capacidade máxima deve ser um valor maior que zero.")
    private Double capacidadeMax;
}