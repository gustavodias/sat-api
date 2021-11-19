package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.controller.dto.CotaPessoaDto;
import hmar.eb.mil.br.sat.modelo.Cota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CotaRepository extends JpaRepository<Cota, Long> {

    Page<Cota> findByGraduacao(String graduacao, Pageable paginacao);

    Cota findByCod(Long cod);

    @Query(value = "SELECT * FROM COTA WHERE YEAR(DATA) = ?1",nativeQuery = true)
    Page<Cota> findByAno(String ano, Pageable paginacao);
}
