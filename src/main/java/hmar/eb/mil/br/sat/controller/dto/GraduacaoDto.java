package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Graduacao;
import org.springframework.data.domain.Page;

public class GraduacaoDto {

    private Long cod;
    private String posto;

    public GraduacaoDto(Graduacao graduacao) {
        this.cod = graduacao.getCod();
        this.posto = graduacao.getPosto();
    }

    public static Page<GraduacaoDto> converter(Page<Graduacao> graduacao) {
        return graduacao.map(GraduacaoDto::new);
    }


    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
