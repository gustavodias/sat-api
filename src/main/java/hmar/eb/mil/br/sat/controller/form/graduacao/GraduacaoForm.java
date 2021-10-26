package hmar.eb.mil.br.sat.controller.form.graduacao;

import hmar.eb.mil.br.sat.modelo.Graduacao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GraduacaoForm {
    @NotNull
    @NotEmpty
    private String posto;

    public String getPosto() {
        return posto;
    }

    public Graduacao converter() {
        return new Graduacao(posto);
    }
}
