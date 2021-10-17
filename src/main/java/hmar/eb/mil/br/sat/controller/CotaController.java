package hmar.eb.mil.br.sat.controller;

import hmar.eb.mil.br.sat.controller.dto.CotaDto;
import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.CotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cota")
public class CotaController {

    @Autowired
    private CotaRepository cotaRepository;

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
}
