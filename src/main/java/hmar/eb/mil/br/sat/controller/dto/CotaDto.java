package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Cota;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CotaDto {

    private Long cod;
    private String graduacao;
    private BigDecimal valor;
    private LocalDateTime data;


    public CotaDto(Cota cota) {
        this.cod = cota.getCod();
       /* this.graduacao = cota.getGraduacao();*/
        this.valor = cota.getValor();
        this.data = cota.getData();
    }

    public static Page<CotaDto> converter(Page<Cota> cotas) {
        return cotas.map(CotaDto::new);
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
