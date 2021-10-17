package hmar.eb.mil.br.sat.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String tipo;
    private String graduacao;
    private String turma;
    private Integer ano;
    private BigInteger preccp;
    private String nome;
    private String nomeGuerra;
    private String endereco;
    private String Percurso;
    @ManyToOne
    private Cota cota;

    public Pessoa() {
        super();
    }

    public Pessoa(Long cod, String tipo, String graduacao, String turma, Integer ano, BigInteger preccp, String nome, String nomeGuerra, String endereco, String percurso, Cota cota) {
        this.cod = cod;
        this.tipo = tipo;
        this.graduacao = graduacao;
        this.turma = turma;
        this.ano = ano;
        this.preccp = preccp;
        this.nome = nome;
        this.nomeGuerra = nomeGuerra;
        this.endereco = endereco;
        Percurso = percurso;
        this.cota = cota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cod, pessoa.cod) && Objects.equals(tipo, pessoa.tipo) && Objects.equals(graduacao, pessoa.graduacao) && Objects.equals(turma, pessoa.turma) && Objects.equals(ano, pessoa.ano) && Objects.equals(preccp, pessoa.preccp) && Objects.equals(nome, pessoa.nome) && Objects.equals(nomeGuerra, pessoa.nomeGuerra) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(Percurso, pessoa.Percurso) && Objects.equals(cota, pessoa.cota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, tipo, graduacao, turma, ano, preccp, nome, nomeGuerra, endereco, Percurso, cota);
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigInteger getPreccp() {
        return preccp;
    }

    public void setPreccp(BigInteger preccp) {
        this.preccp = preccp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPercurso() {
        return Percurso;
    }

    public void setPercurso(String percurso) {
        Percurso = percurso;
    }

    public Cota getCota() {
        return cota;
    }

    public void setCota(Cota cota) {
        this.cota = cota;
    }
}
