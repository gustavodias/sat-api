package hmar.eb.mil.br.sat.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Trajeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String descricao;
    private LocalDateTime data = LocalDateTime.now();
    @ManyToOne
    private Pessoa pessoa;
    @ManyToOne
    private Passagem passagem;

    public Trajeto() {
        super();
    }

    public Trajeto(String descricao, Pessoa pessoa, Passagem passagem) {
        this.descricao = descricao;
        this.pessoa = pessoa;
        this.passagem = passagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trajeto)) return false;
        Trajeto trajeto = (Trajeto) o;
        return Objects.equals(cod, trajeto.cod) && Objects.equals(descricao, trajeto.descricao) && Objects.equals(data, trajeto.data) && Objects.equals(pessoa, trajeto.pessoa) && Objects.equals(passagem, trajeto.passagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, descricao, data, pessoa, passagem);
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
}
