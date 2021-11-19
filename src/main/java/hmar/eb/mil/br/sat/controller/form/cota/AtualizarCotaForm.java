package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.CotaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AtualizarCotaForm {
    @NotNull
    @NotEmpty
    private String gradPosto;
    @NotNull
    private BigDecimal valor;

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getGradPosto() {
        return gradPosto;
    }

    public void setGradPosto(String gradPosto) {
        this.gradPosto = gradPosto;
    }

    public Cota atualizar(Long cod, CotaRepository cotaRepository){
        var cota = cotaRepository.getById(cod);
        cota.setValor(this.valor);
        return cota;
    }
}
