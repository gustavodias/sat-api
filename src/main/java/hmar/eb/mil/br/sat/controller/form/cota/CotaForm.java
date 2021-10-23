package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;
import hmar.eb.mil.br.sat.repository.PessoaRepository;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CotaForm {
    @NotNull
    private Long codGraduacao;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Long codPessoa;

    public Cota converter(PessoaRepository pessoaRepository, GraduacaoRepository graduacaoRepository){
        var pessoa = pessoaRepository.getById(codPessoa);
        var graduacao = graduacaoRepository.getById(codGraduacao);

        var cota = new Cota(graduacao,valor);
        cota.getPessoa().add(pessoa);
        return cota;
    }

    public Long getCodGraduacao() {
        return codGraduacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }
}
