package hmar.eb.mil.br.sat.controller.form.passagem;

import hmar.eb.mil.br.sat.modelo.Passagem;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PassagemForm {

    @NotNull @NotEmpty
    private String tarifa;
    @NotNull
    private BigDecimal valor;

    public String getTarifa() {
        return tarifa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Passagem converter() {
        return new Passagem(tarifa, valor);
    }
}
