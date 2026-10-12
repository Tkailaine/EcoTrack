package br.com.fiap.EcoTrack.repository;

import br.com.fiap.EcoTrack.model.PontoColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
}