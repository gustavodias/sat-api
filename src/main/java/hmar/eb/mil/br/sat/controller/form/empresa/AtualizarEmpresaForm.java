package hmar.eb.mil.br.sat.controller.form.empresa;

import hmar.eb.mil.br.sat.modelo.Empresa;
import hmar.eb.mil.br.sat.repository.EmpresaRepository;

public class AtualizarEmpresaForm {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa atualizar(Long cod, EmpresaRepository empresaRepository){
        var empresa = empresaRepository.getById(cod);
        empresa.setNome(this.nome);
        return empresa;
    }
}
