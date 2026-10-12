package br.com.fiap.EcoTrack.dto;

import lombok.Data;

@Data
public class PontoColetaResponse {
    private Long idPonto;
    private String local;
    private Double capacidadMax;
}