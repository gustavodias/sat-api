package hmar.eb.mil.br.sat.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String tarifa;
    private BigDecimal valor;
    private LocalDateTime data = LocalDateTime.now();

    public Passagem() {
        super();
    }

    public Passagem(String tarifa, BigDecimal valor) {
        this.tarifa = tarifa;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passagem)) return false;
        Passagem passagem = (Passagem) o;
        return cod.equals(passagem.cod) && tarifa.equals(passagem.tarifa) && valor.equals(passagem.valor) && data.equals(passagem.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, tarifa, valor, data);
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
