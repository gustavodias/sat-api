package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Passagem;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PassagemDto {

    private Long cod;
    private String tarifa;
    private BigDecimal valor;
    private LocalDateTime data;

    public PassagemDto(Passagem passagem) {
        this.cod = passagem.getCod();
        this.tarifa = passagem.getTarifa();
        this.valor = passagem.getValor();
        this.data = passagem.getData();
    }

    public static Page<PassagemDto> converter(Page<Passagem> passagens) {
        return passagens.map(PassagemDto::new);
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }



}
