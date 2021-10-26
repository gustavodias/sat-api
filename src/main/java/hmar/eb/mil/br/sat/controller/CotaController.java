package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.CotaDto;
import hmar.eb.mil.br.sat.controller.dto.CotaPessoaDto;
import hmar.eb.mil.br.sat.controller.dto.PessoaDto;
import hmar.eb.mil.br.sat.controller.form.cota.AtualizarCotaForm;
import hmar.eb.mil.br.sat.controller.form.cota.CotaForm;
import hmar.eb.mil.br.sat.controller.form.cota.CotaPessoaForm;
import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import hmar.eb.mil.br.sat.repository.CotaRepository;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;
import hmar.eb.mil.br.sat.repository.PessoaRepository;
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
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cotas")
public class CotaController {

    @Autowired
    private CotaRepository cotaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @GetMapping
    @Cacheable(value = "listaDeCotas")
    public Page<CotaDto> lista(@RequestParam(required = false) String graduacao,
                            @PageableDefault(sort = "data", direction = Sort.Direction.DESC, page = 0, size = 10)Pageable paginacao){
        if (graduacao == null){
            Page<Cota> cotas = cotaRepository.findAll(paginacao);
            return CotaDto.converter(cotas);
        } else{
            Page<Cota> cotas = cotaRepository.findByGraduacao(graduacao, paginacao);
            return CotaDto.converter(cotas);
        }
    }

    @GetMapping("/listaDetalhada")
    @Cacheable(value = "listaDetalhada")
    public ResponseEntity<List<PessoaDto>> listar2(@RequestParam(required = false) Long cod){

        return ResponseEntity.ok().body(cotaRepository.findById(cod).orElse(new Cota()).
                getPessoa().stream().map(pessoa -> new PessoaDto(pessoa.getNome())).collect(Collectors.toList()));
    }

    @GetMapping("/listaDetalhada2")
    @Cacheable(value = "listaDetalhada")
    public ResponseEntity<List<CotaPessoaDto>> listar3(@RequestParam(required = false) Long cod){
        return ResponseEntity.ok().body(cotaRepository.findById(cod).orElse(new Cota()).
                getPessoa().stream().map(pessoa -> new CotaPessoaDto(pessoa.getCotas().stream().map(CotaDto::new).collect(Collectors.toList()), pessoa.getGraduacao().getCod(), pessoa.getCod())).collect(Collectors.toList()));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeCotas", allEntries = true)
    public ResponseEntity<CotaDto> cadastrar(@RequestBody @Valid CotaForm cotaForm, UriComponentsBuilder uriBuilder){
            Cota cota = cotaForm.converter(pessoaRepository, graduacaoRepository);

            cotaRepository.save(cota);

        URI uri = uriBuilder.path("/{cod}").buildAndExpand(cota.getCod()).toUri();
        return ResponseEntity.created(uri).body(new CotaDto(cota));
    }

    @PostMapping("/associarCotaPessoa")
    @Transactional
    @CacheEvict(value = "listaDeCotas", allEntries = true)
    public ResponseEntity<Void> associarCotaPessoa(@RequestBody @Valid CotaPessoaForm cotaPessoaForm){
        Cota cota = cotaPessoaForm.converter(pessoaRepository, cotaRepository);
        cotaRepository.save(cota);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeCotas", allEntries = true)
    public ResponseEntity<CotaDto> atualizar(@PathVariable Long cod, @RequestBody @Valid AtualizarCotaForm atualizarCotaForm){
        var optional = cotaRepository.findById(cod);

        if (optional.isPresent()){
            var cota = atualizarCotaForm.atualizar(cod, cotaRepository);
            return ResponseEntity.ok(new CotaDto(cota));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeCotas", allEntries = true)
    public ResponseEntity<Void> remover(@PathVariable Long cod){
        var optional = cotaRepository.findById(cod);
        if (optional.isPresent()){
            cotaRepository.deleteById(cod);
            return  ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
