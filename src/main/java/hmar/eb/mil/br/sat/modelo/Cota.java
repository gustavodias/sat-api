package hmar.eb.mil.br.sat.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private BigDecimal valor;
    private LocalDateTime data = LocalDateTime.now();
    @ManyToOne
    private Graduacao graduacao;
    @ManyToMany
    @JoinTable(
            name = "CotaPessoa",
            uniqueConstraints = @UniqueConstraint(columnNames = {"cod_pessoa", "cod_cota"}),
            joinColumns = @JoinColumn(name = "cod_cota"),
            inverseJoinColumns = @JoinColumn(name = "cod_pessoa")
    )
    private List<Pessoa> pessoa = new ArrayList<>();

    public Cota() {
        super();
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public Cota(BigDecimal valor, Graduacao grad){
        this.valor = valor;
        this.graduacao = grad;
    }

    public Cota(Graduacao graduacao, BigDecimal valor) {
        this.graduacao = graduacao;
        this.valor = valor;
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

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
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
