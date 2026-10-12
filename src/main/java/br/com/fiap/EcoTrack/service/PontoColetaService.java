package br.com.fiap.EcoTrack.service;

import br.com.fiap.EcoTrack.dto.PontoColetaRequest;
import br.com.fiap.EcoTrack.dto.PontoColetaResponse;
import br.com.fiap.EcoTrack.exception.BusinessException;
import br.com.fiap.EcoTrack.exception.ResourceNotFoundException;
import br.com.fiap.EcoTrack.model.PontoColeta;
import br.com.fiap.EcoTrack.repository.PontoColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository repository;

    // GET (Listar Todos)
    public List<PontoColetaResponse> listarTodos() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET (Buscar por ID)
    public PontoColetaResponse buscarPorId(Long id) {
        PontoColeta ponto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ponto de coleta não encontrado com o ID: " + id));
        return mapToResponse(ponto);
    }

    // POST (Criar)
    public PontoColetaResponse criar(PontoColetaRequest request) {
        if (repository.existsById(request.getIdPonto())) {
            throw new BusinessException("Já existe um ponto de coleta com o ID: " + request.getIdPonto());
        }
        PontoColeta ponto = new PontoColeta();
        ponto.setIdPonto(request.getIdPonto());
        ponto.setLocal(request.getLocal());
        ponto.setCapacidadeMax(request.getCapacidadeMax());

        return mapToResponse(repository.save(ponto));
    }

    // PUT (Atualizar)
    public PontoColetaResponse atualizar(Long id, PontoColetaRequest request) {
        PontoColeta ponto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ponto de coleta não encontrado com o ID: " + id));

        ponto.setLocal(request.getLocal());
        ponto.setCapacidadeMax(request.getCapacidadeMax());

        return mapToResponse(repository.save(ponto));
    }

    // DELETE (Excluir)
    public void deletar(Long id) {
        PontoColeta ponto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ponto de coleta não encontrado com o ID: " + id));
        repository.delete(ponto);
    }

    private PontoColetaResponse mapToResponse(PontoColeta ponto) {
        PontoColetaResponse response = new PontoColetaResponse();
        response.setIdPonto(ponto.getIdPonto());
        response.setLocal(ponto.getLocal());
        response.setCapacidadMax(ponto.getCapacidadeMax());
        return response;
    }
}