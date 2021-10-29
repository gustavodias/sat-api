package hmar.eb.mil.br.sat.repository;

import hmar.eb.mil.br.sat.modelo.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByNome(String nome, Pageable paginacao);
}
