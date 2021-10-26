package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.GraduacaoDto;
import hmar.eb.mil.br.sat.controller.form.graduacao.AtualizarGraduacaoForm;
import hmar.eb.mil.br.sat.controller.form.graduacao.GraduacaoForm;
import hmar.eb.mil.br.sat.controller.form.passagem.AtualizarPassagemForm;
import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/graduacao")
public class GraduacaoController {

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @GetMapping
    @Transactional
    @Cacheable(value = "listaDeGraduacoes")
    public Page<GraduacaoDto> listar(@PageableDefault (sort = "posto", direction = Sort.Direction.ASC, size = 10, page = 0)Pageable pageable){
        Page<Graduacao> graduacao = graduacaoRepository.findAll(pageable);
        return GraduacaoDto.converter(graduacao);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeGraduacoes", allEntries = true)
    public ResponseEntity<GraduacaoDto> cadastrar(@RequestBody @Valid GraduacaoForm graduacaoForm, UriComponentsBuilder uriComponentsBuilder){
        var graduacao = graduacaoForm.converter();
        graduacaoRepository.save(graduacao);

        URI uri = uriComponentsBuilder.path("/{cod}").buildAndExpand(graduacao.getCod()).toUri();
        return ResponseEntity.created(uri).body(new GraduacaoDto(graduacao));
    }

    @PutMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeGraduacoes", allEntries = true)
    public ResponseEntity<GraduacaoDto> atualizar(@PathVariable Long cod, @RequestBody @Valid AtualizarGraduacaoForm atualizarGraduacaoForm){
        var optional = graduacaoRepository.findById(cod);

        if (optional.isPresent()){
            var graduacao =atualizarGraduacaoForm.atualizar(cod, graduacaoRepository);
            return ResponseEntity.ok(new GraduacaoDto(graduacao));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeGraduacoes", allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable Long cod){
        var optional = graduacaoRepository.findById(cod);

        if (optional.isPresent()){
            graduacaoRepository.deleteById(cod);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
