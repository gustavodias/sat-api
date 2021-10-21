package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.PassagemDto;
import hmar.eb.mil.br.sat.modelo.Passagem;
import hmar.eb.mil.br.sat.repository.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passagens")
public class PassagemController {

    @Autowired
    private PassagemRepository passagemRepository;

    @GetMapping
    @Transactional
    @Cacheable(value = "listaDePassagens")
    public Page<PassagemDto> listar(@RequestParam(required = false) String tarifa,
                                   @PageableDefault(sort = "tarifa", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        if (tarifa == null){
            Page<Passagem> passagens = passagemRepository.findAll(paginacao);
            return PassagemDto.converter(passagens);
        } else {
            Page<Passagem> passagens = passagemRepository.findByTarifa(tarifa, paginacao);
            return PassagemDto.converter(passagens);
        }
    }


}
