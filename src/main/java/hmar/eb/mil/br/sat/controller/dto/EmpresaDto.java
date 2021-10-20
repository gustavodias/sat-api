package hmar.eb.mil.br.sat.controller.dto;

import hmar.eb.mil.br.sat.modelo.Empresa;
import org.springframework.data.domain.Page;

public class EmpresaDto {

    private Long cod;
    private String nome;

    public EmpresaDto(Empresa empresa) {
        this.cod = empresa.getCod();
        this.nome = empresa.getNome();
    }

    public static Page<EmpresaDto> converter(Page<Empresa> empresas){ return empresas.map(EmpresaDto::new); }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
