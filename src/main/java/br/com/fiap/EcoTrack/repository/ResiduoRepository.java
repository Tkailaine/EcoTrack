package br.com.fiap.EcoTrack.repository;

import br.com.fiap.EcoTrack.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
}