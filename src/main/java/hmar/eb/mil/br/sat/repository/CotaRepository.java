package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Cota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotaRepository extends JpaRepository<Cota, Long> {

}
