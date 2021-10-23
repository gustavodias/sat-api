package hmar.eb.mil.br.sat.controller.form.cota;

import hmar.eb.mil.br.sat.modelo.Cota;
import hmar.eb.mil.br.sat.repository.CotaRepository;
import hmar.eb.mil.br.sat.repository.PessoaRepository;

import javax.validation.constraints.NotNull;

public class CotaPessoaForm {
        @NotNull
        private Long codCota;
        @NotNull
        private Long codPessoa;

        public Cota converter(PessoaRepository pessoaRepository, CotaRepository cotaRepository){
            var pessoa = pessoaRepository.getById(codPessoa);
            var cota = cotaRepository.getById(codCota);

            cota.getPessoa().add(pessoa);
            return cota;
        }

    public Long getCodCota() {
        return codCota;
    }

    public Long getCodPessoa() {
            return codPessoa;
        }

}
