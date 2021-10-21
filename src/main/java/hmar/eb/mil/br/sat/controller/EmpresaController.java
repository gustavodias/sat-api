package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.EmpresaDto;
import hmar.eb.mil.br.sat.controller.form.empresa.AtualizarEmpresaForm;
import hmar.eb.mil.br.sat.controller.form.empresa.EmpresaForm;
import hmar.eb.mil.br.sat.modelo.Empresa;
import hmar.eb.mil.br.sat.repository.EmpresaRepository;
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
import java.net.URI;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    @Transactional
    @Cacheable(value = "listaDeEmpresas")
    public Page<EmpresaDto> listar(@RequestParam(required = false) String nome,
                                             @PageableDefault(sort = "nome", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        if (nome == null){
            Page<Empresa> empresas = empresaRepository.findAll(paginacao);
            return EmpresaDto.converter(empresas);
        } else {
            Page<Empresa> empresas = empresaRepository.findByNome(nome, paginacao);
            return EmpresaDto.converter(empresas);
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeEmpresas", allEntries = true)
    public ResponseEntity<EmpresaDto> cadastrar(@RequestBody @Valid EmpresaForm empresaForm, UriComponentsBuilder uriComponentsBuilder){
        Empresa empresa = empresaForm.converter();
        empresaRepository.save(empresa);

        URI uri = uriComponentsBuilder.path("/{cod}").buildAndExpand(empresa.getCod()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDto(empresa));
    }

    @PutMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeEmpresas", allEntries = true)
    public ResponseEntity<EmpresaDto> atualizar(@PathVariable Long cod, @RequestBody @Valid AtualizarEmpresaForm atualizarEmpresaForm){
        var optional = empresaRepository.findById(cod);

        if (optional.isPresent()){
            var empresa = atualizarEmpresaForm.atualizar(cod, empresaRepository);
            return ResponseEntity.ok(new EmpresaDto(empresa));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cod}")
    @Transactional
    @CacheEvict(value = "listaDeEmpresas", allEntries = true)
    public ResponseEntity<Void> remover(@PathVariable Long cod){
        var optional = empresaRepository.findById(cod);

        if (optional.isPresent()){
            empresaRepository.deleteById(cod);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
