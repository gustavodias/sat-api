package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Empresa;
import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import org.springframework.data.domain.Page;

import java.math.BigInteger;

public class PessoaDto {

    private Long cod;
    private String tipo;
    private String posto;
    private String turma;
    private Integer ano;
    private BigInteger preccp;
    private String nome;
    private String nomeGuerra;
    private String endereco;
    private String percurso;
    private Graduacao graduacao;
    private Empresa empresa;

    public PessoaDto(String nome) {
        this.nome = nome;
    }

    public PessoaDto(Pessoa pessoa) {
        this.cod = pessoa.getCod();
        this.tipo = pessoa.getTipo();
        this.posto = pessoa.getGraduacao().getPosto();
        this.turma = pessoa.getTurma();
        this.ano = pessoa.getAno();
        this.preccp = pessoa.getPreccp();
        this.nome = pessoa.getNome();
        this.nomeGuerra = pessoa.getNomeGuerra();
        this.endereco = pessoa.getEndereco();
        this.percurso = pessoa.getPercurso();
        this.graduacao = pessoa.getGraduacao();
        this.empresa = pessoa.getEmpresa();
    }

    public static Page<PessoaDto> converter(Page<Pessoa> pessoa) {
        return pessoa.map(PessoaDto::new);
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
