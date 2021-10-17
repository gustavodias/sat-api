package hmar.eb.mil.br.sat.controller.form;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import hmar.eb.mil.br.sat.repository.PessoaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CotaForm {
    @NotNull @NotEmpty
    private String graduacao;
    @NotNull @NotEmpty
    private String valor;
    @NotNull @NotEmpty
    private Long codPessoa;

    public Cota converter(PessoaRepository pessoaRepository){
        Pessoa pessoa = pessoaRepository.getById(codPessoa);
        return new Cota(graduacao, new BigDecimal(valor), pessoa);
    }

    public String getGraduacao() {
        return graduacao;
    }

    public String getValor() {
        return valor;
    }
}
