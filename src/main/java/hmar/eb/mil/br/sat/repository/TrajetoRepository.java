package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Trajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepository extends JpaRepository<Trajeto, Long> {

}
