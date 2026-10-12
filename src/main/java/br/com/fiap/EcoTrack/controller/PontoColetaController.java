package br.com.fiap.EcoTrack.controller;

import br.com.fiap.EcoTrack.dto.PontoColetaRequest;
import br.com.fiap.EcoTrack.dto.PontoColetaResponse;
import br.com.fiap.EcoTrack.service.PontoColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pontos-coleta")
public class PontoColetaController {

    @Autowired
    private PontoColetaService service;

    // 1. GET - Listar todos
    @GetMapping
    public ResponseEntity<List<PontoColetaResponse>> getAll() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 2. GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // 3. POST - Cadastrar novo ponto
    @PostMapping
    public ResponseEntity<PontoColetaResponse> create(@Valid @RequestBody PontoColetaRequest request) {
        PontoColetaResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 4. PUT - Atualizar ponto existente
    @PutMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> update(@PathVariable Long id, @Valid @RequestBody PontoColetaRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    // 5. DELETE - Remover ponto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}