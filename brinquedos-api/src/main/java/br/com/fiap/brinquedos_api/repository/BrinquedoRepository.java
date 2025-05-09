package br.com.fiap.brinquedos_api.repository;

import br.com.fiap.brinquedos_api.entity.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Adicione esta anotação
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
