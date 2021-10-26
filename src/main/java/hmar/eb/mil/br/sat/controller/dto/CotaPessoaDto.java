package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class CotaPessoaDto {

    private List<CotaDto> codCota;
    private Long codGrad;
    private Long codPessoa;

    public CotaPessoaDto(List<CotaDto> codCota, Long codGrad, Long codPessoa) {
        this.codCota = codCota;
        this.codGrad = codGrad;
        this.codPessoa = codPessoa;
    }

    public static Page<CotaPessoaDto> converter(Page<Pessoa> pessoa) {
        return pessoa.map(pessoa1 -> new CotaPessoaDto(pessoa1.getCotas().stream().map(CotaDto::new).collect(Collectors.toList()), pessoa1.getGraduacao().getCod(), pessoa1.getCod()));
    }

    public List<CotaDto> getCodCota() {
        return codCota;
    }

    public void setCodCota(List<CotaDto> codCota) {
        this.codCota = codCota;
    }

    public Long getCodGrad() {
        return codGrad;
    }

    public void setCodGrad(Long codGrad) {
        this.codGrad = codGrad;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
    }
}
