package hmar.eb.mil.br.sat.controller.form.graduacao;

import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarGraduacaoForm {

    @NotNull
    @NotEmpty
    private String posto;

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public Graduacao atualizar(Long cod, GraduacaoRepository graduacaoRepository) {
        Graduacao graduacao = graduacaoRepository.getById(cod);
        graduacao.setPosto(this.posto);
        return graduacao;
    }
}
