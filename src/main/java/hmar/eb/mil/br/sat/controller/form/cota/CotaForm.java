package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CotaForm {
    @NotNull
    private BigDecimal valor;
    @NotNull @NotEmpty
    private String gradPosto;

    public Cota converter(GraduacaoRepository graduacaoRepository) {
        var graduacao = graduacaoRepository.getByPosto(gradPosto);
        return new Cota(valor, graduacao);
    }

    public String getGradPosto() {
        return gradPosto;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
