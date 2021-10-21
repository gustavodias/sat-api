package hmar.eb.mil.br.sat.controller.form.passagem;

import hmar.eb.mil.br.sat.modelo.Passagem;
import hmar.eb.mil.br.sat.repository.PassagemRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AtualizarPassagemForm {

    @NotNull
    @NotEmpty
    private String tarifa;
    @NotNull
    private BigDecimal valor;

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    private Passagem atualizar(Long cod, PassagemRepository passagemRepository){
        var passagem = passagemRepository.getById(cod);
        passagem.setTarifa(this.tarifa);
        passagem.setValor(this.valor);
        return passagem;
    }
}
