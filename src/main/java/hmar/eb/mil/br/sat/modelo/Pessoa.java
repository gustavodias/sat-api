package hmar.eb.mil.br.sat.modelo;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String tipo;
    private String turma;
    private Integer ano;
    private BigInteger preccp;
    private String nome;
    private String nomeGuerra;
    private String endereco;
    private String percurso;
    @ManyToOne
    private Graduacao graduacao;
    @ManyToOne
    private Empresa empresa;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "CotaPessoa",
            uniqueConstraints = @UniqueConstraint(columnNames = {"cod_pessoa", "cod_cota"}),
            joinColumns = @JoinColumn(name = "cod_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "cod_cota")
    )
    private List<Cota> cotas = new ArrayList<>();
    @OneToMany(mappedBy = "pessoa")
    private List<Trajeto> trajetos = new ArrayList<>();

    public Pessoa(String tipo, String turma, Integer ano, BigInteger preccp, String nome, String nomeGuerra, String endereco, String percurso, Graduacao graduacao, Empresa empresa) {
        this.tipo = tipo;
        this.turma = turma;
        this.ano = ano;
        this.preccp = preccp;
        this.nome = nome;
        this.nomeGuerra = nomeGuerra;
        this.endereco = endereco;
        this.percurso = percurso;
        this.graduacao = graduacao;
        this.empresa = empresa;
    }

    public List<Cota> getCotas() {
        return cotas;
    }

    public void setCotas(List<Cota> cotas) {
        this.cotas = cotas;
    }

    public List<Trajeto> getTrajetos() {
        return trajetos;
    }

    public void setTrajetos(List<Trajeto> trajetos) {
        this.trajetos = trajetos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cod, pessoa.cod) && Objects.equals(tipo, pessoa.tipo) && Objects.equals(turma, pessoa.turma) && Objects.equals(ano, pessoa.ano) && Objects.equals(preccp, pessoa.preccp) && Objects.equals(nome, pessoa.nome) && Objects.equals(nomeGuerra, pessoa.nomeGuerra) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(percurso, pessoa.percurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, tipo, turma, ano, preccp, nome, nomeGuerra, endereco, percurso);
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Pessoa() {
        super();
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
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }
}
