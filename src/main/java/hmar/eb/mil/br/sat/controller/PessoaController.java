package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.PessoaDto;
import hmar.eb.mil.br.sat.controller.form.pessoa.AtualizarPessoaForm;
import hmar.eb.mil.br.sat.controller.form.pessoa.PessoaForm;
import hmar.eb.mil.br.sat.repository.CotaRepository;
import hmar.eb.mil.br.sat.repository.EmpresaRepository;
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

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private GraduacaoRepository graduacaoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private CotaRepository cotaRepository;

    @GetMapping
    @Cacheable(value = "listaDePessoas")
    public Page<PessoaDto> lista(@RequestParam (required = false) String nome,
                                 @PageableDefault (sort = "cod", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){

        if (nome == null){
            var pessoa = pessoaRepository.findAll(paginacao);
            return PessoaDto.converter(pessoa);
        }else {
            var pessoa = pessoaRepository.findByNome(nome, paginacao);
            return PessoaDto.converter(pessoa);
        }
    }
    

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDePessoas", allEntries = true)
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriComponentsBuilder){
        var pessoa = pessoaForm.converter(graduacaoRepository, empresaRepository);

        pessoaRepository.save(pessoa);

        var uri = uriComponentsBuilder.path("{cod}").buildAndExpand(pessoa.getCod()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }

    @PutMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDePessoas", allEntries = true)
    public ResponseEntity<PessoaDto> atualizar(@PathVariable Long cod, @RequestBody @Valid AtualizarPessoaForm pessoaForm){
        var optional = pessoaRepository.findById(cod);

        if (optional.isPresent()){
            var pessoa = pessoaForm.atualizar(cod, pessoaRepository, graduacaoRepository, empresaRepository);
            return ResponseEntity.ok(new PessoaDto(pessoa));
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDePessoas", allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable Long cod){
        var optional = pessoaRepository.findById(cod);

        if (optional.isPresent()){
            pessoaRepository.deleteById(cod);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
