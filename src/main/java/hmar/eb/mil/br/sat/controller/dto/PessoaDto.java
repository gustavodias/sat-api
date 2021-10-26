package hmar.eb.mil.br.sat.controller.dto;

public class PessoaDto {

    private String nome;

    public PessoaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
