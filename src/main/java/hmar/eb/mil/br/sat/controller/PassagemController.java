package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.PassagemDto;
import hmar.eb.mil.br.sat.controller.form.passagem.AtualizarPassagemForm;
import hmar.eb.mil.br.sat.controller.form.passagem.PassagemForm;
import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.modelo.Passagem;
import hmar.eb.mil.br.sat.repository.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/passagens")
public class PassagemController {

    @Autowired
    private PassagemRepository passagemRepository;

    @GetMapping
    @Transactional
    @Cacheable(value = "listaDePassagens")
    public Page<PassagemDto> listar(@RequestParam(required = false) String tarifa,
                                    @PageableDefault(sort = "tarifa", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        if (tarifa == null) {
            Page<Passagem> passagens = passagemRepository.findAll(paginacao);
            return PassagemDto.converter(passagens);
        } else {
            Page<Passagem> passagens = passagemRepository.findByTarifa(tarifa, paginacao);
            return PassagemDto.converter(passagens);
        }
    }

    @GetMapping(value = "/{cod}")
    @Transactional
    public ResponseEntity<Passagem> findByCod(@PathVariable Long cod) {
        Passagem obj = passagemRepository.findByCod(cod);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDePassagens", allEntries = true)
    public ResponseEntity<PassagemDto> cadastrar(@RequestBody @Valid PassagemForm passagemForm, UriComponentsBuilder uriComponentsBuilder) {
        var passagem = passagemForm.converter();
        passagemRepository.save(passagem);

        var uri = uriComponentsBuilder.path("/{cod}").buildAndExpand(passagem.getCod()).toUri();
        return ResponseEntity.created(uri).body(new PassagemDto(passagem));
    }

    @PutMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDePassagens", allEntries = true)
    public ResponseEntity<PassagemDto> atualizar(@PathVariable Long cod, @RequestBody @Valid AtualizarPassagemForm atualizarPassagemForm) {
        var optional = passagemRepository.findById(cod);

        if (optional.isPresent()) {
            var passagem = atualizarPassagemForm.atualizar(cod, passagemRepository);
            return ResponseEntity.ok(new PassagemDto(passagem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDePassagens", allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable Long cod) {
        var optional = passagemRepository.findById(cod);

        if (optional.isPresent()) {
            passagemRepository.deleteById(cod);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
