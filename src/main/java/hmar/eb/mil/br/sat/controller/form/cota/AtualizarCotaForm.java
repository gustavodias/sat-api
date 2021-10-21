package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.CotaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AtualizarCotaForm {
    @NotNull
    @NotEmpty
    private String graduacao;
    @NotNull
    private BigDecimal valor;

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Cota atualizar(Long cod, CotaRepository cotaRepository){
        var cota = cotaRepository.getById(cod);
        cota.setGraduacao(this.graduacao);
        cota.setValor(this.valor);
        return cota;
    }
}
