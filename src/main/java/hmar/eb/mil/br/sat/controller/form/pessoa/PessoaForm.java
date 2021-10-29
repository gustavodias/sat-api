package hmar.eb.mil.br.sat.controller.form.pessoa;

import hmar.eb.mil.br.sat.modelo.Graduacao;
import hmar.eb.mil.br.sat.modelo.Pessoa;
import hmar.eb.mil.br.sat.repository.EmpresaRepository;
import hmar.eb.mil.br.sat.repository.GraduacaoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class PessoaForm {
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

    public Pessoa converter(GraduacaoRepository graduacaoRepository, EmpresaRepository empresaRepository){
        var empresa = empresaRepository.getById(codEmpresa);
        var graduacao = graduacaoRepository.getById(codGraduacao);
        return new Pessoa(tipo, turma, ano, preccp, nome, nomeGuerra, endereco, percurso, graduacao, empresa);
    }

    public String getTipo() {
        return tipo;
    }

    public Long getCodGraduacao() {
        return codGraduacao;
    }

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public String getTurma() {
        return turma;
    }

    public Integer getAno() {
        return ano;
    }

    public BigInteger getPreccp() {
        return preccp;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPercurso() {
        return percurso;
    }
}
