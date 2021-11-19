package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findByNome(String nome, Pageable paginacao);

    Empresa findByCod(Long cod);
}
