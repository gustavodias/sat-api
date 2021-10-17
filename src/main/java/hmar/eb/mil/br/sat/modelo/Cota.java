package hmar.eb.mil.br.sat.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String graduacao;
    private BigDecimal valor;
    private LocalDateTime data = LocalDateTime.now();

    @ManyToOne
    private Pessoa pessoa;

    public Cota() {
        super();
    }

    public Cota(String graduacao, BigDecimal valor, Pessoa pessoa) {
        this.graduacao = graduacao;
        this.valor = valor;
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cota)) return false;
        Cota cota = (Cota) o;
        return cod.equals(cota.cod) && graduacao.equals(cota.graduacao) && valor.equals(cota.valor) && data.equals(cota.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, graduacao, valor, data);
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
