package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.PessoaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CotaForm {
    @NotNull @NotEmpty
    private String graduacao;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Long codPessoa;

    public Cota converter(PessoaRepository pessoaRepository){
        var pessoa = pessoaRepository.getById(codPessoa);
        return new Cota(graduacao, valor, pessoa);
    }

    public String getGraduacao() {
        return graduacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }
}
