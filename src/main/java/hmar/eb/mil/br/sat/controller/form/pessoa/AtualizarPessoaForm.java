package hmar.eb.mil.br.sat.controller.form.pessoa;

import hmar.eb.mil.br.sat.modelo.Empresa;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import hmar.eb.mil.br.sat.repository.EmpresaRepository;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;
import hmar.eb.mil.br.sat.repository.PessoaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class AtualizarPessoaForm {

    @NotEmpty @NotNull
    private String tipo;
    @NotNull
    private Long codGraduacao;
    @NotEmpty @NotNull
    private String turma;
    @NotNull
    private Integer ano;
    @NotNull
    private BigInteger preccp;
    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private String nomeGuerra;
    @NotEmpty @NotNull
    private String endereco;
    @NotEmpty @NotNull
    private String percurso;
    @NotNull
    private Long codEmpresa;

    public Pessoa atualizar(Long cod, PessoaRepository pessoaRepository, GraduacaoRepository graduacaoRepository, EmpresaRepository empresaRepository){
        var pessoa = pessoaRepository.getById(cod);
        var graduacao = graduacaoRepository.getById(codGraduacao);
        var empresa = empresaRepository.getById(codEmpresa);
        pessoa.setTipo(this.tipo);
        pessoa.setTurma(this.turma);
        pessoa.setAno(this.ano);
        pessoa.setPreccp(this.preccp);
        pessoa.setNome(this.nome);
        pessoa.setNomeGuerra(this.nomeGuerra);
        pessoa.setEndereco(this.endereco);
        pessoa.setPercurso(this.percurso);
        pessoa.setGraduacao(graduacao);
        pessoa.setEmpresa(empresa);
        return pessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCodGraduacao() {
        return codGraduacao;
    }

    public void setCodGraduacao(Long codGraduacao) {
        this.codGraduacao = codGraduacao;
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

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
}
