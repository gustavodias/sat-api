package hmar.eb.mil.br.sat.controller.form.empresa;

import hmar.eb.mil.br.sat.modelo.Empresa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmpresaForm {

    @NotEmpty @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }
    public Empresa converter() {
        return new Empresa(nome);
    }
}
