package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Graduacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraduacaoRepository extends JpaRepository<Graduacao, Long> {
    Graduacao getByPosto(String posto);
}
