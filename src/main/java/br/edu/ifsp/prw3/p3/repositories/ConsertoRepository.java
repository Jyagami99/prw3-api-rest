package br.edu.ifsp.prw3.p3.repositories;

import br.edu.ifsp.prw3.p3.models.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}