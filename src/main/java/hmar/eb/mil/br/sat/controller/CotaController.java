package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.CotaDto;
import hmar.eb.mil.br.sat.controller.form.CotaForm;
import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.CotaRepository;
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
@RequestMapping("/cota")
public class CotaController {

    @Autowired
    private CotaRepository cotaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

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

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeCotas")
    public ResponseEntity<CotaDto> cadastrar(@RequestBody @Valid CotaForm cotaForm, UriComponentsBuilder uriBuilder){
            var cota = cotaForm.converter(pessoaRepository);
            cotaRepository.save(cota);

            var uri = uriBuilder.path("/{id}").buildAndExpand(cota.getCod()).toUri();
            return ResponseEntity.created(uri).body(new CotaDto(cota));
    }
}
