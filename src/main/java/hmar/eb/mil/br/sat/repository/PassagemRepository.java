package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
