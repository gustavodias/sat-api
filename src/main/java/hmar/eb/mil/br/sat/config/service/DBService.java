package hmar.eb.mil.br.sat.config.service;

import hmar.eb.mil.br.sat.modelo.*;
import hmar.eb.mil.br.sat.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

@Service
public class DBService {

    private final CotaRepository cotaRepository;
    private final GraduacaoRepository graduacaoRepository;
    private final EmpresaRepository empresaRepository;
    private final PassagemRepository passagemRepository;
    private final PessoaRepository pessoaRepository;
    private final TrajetoRepository trajetoRepository;

    public DBService(CotaRepository cotaRepository, GraduacaoRepository graduacaoRepository, EmpresaRepository empresaRepository, PassagemRepository passagemRepository, PessoaRepository pessoaRepository, TrajetoRepository trajetoRepository) {
        this.graduacaoRepository = graduacaoRepository;
        this.cotaRepository = cotaRepository;
        this.empresaRepository = empresaRepository;
        this.passagemRepository = passagemRepository;
        this.pessoaRepository = pessoaRepository;
        this.trajetoRepository = trajetoRepository;
    }

    public void instaciaBaseDeDados() {

        var grad1 = new Graduacao("SD EV");
        var grad2 = new Graduacao("SD EP");
        var grad3 = new Graduacao("CB");
        var grad4 = new Graduacao("3º SGT");
        var grad5 = new Graduacao("2º SGT");
        var grad6 = new Graduacao("1º SGT");
        var grad7 = new Graduacao("SUB TEN");

        var emp1 = new Empresa("MOBI PE");
        var emp2 = new Empresa("RODOTUR");
        var emp3 = new Empresa("TRANSCOL");

        Passagem pas1 = new Passagem("A", new BigDecimal("3.75"));
        Passagem pas2 = new Passagem("B", new BigDecimal("5.10"));
        Passagem pas3 = new Passagem("G", new BigDecimal("2.45"));

        Cota cota1 = new Cota(grad1, new BigDecimal("20"));
        Cota cota2 = new Cota(grad2, new BigDecimal("30"));
        Cota cota3 = new Cota(grad1, new BigDecimal("40"));
        Cota cota4 = new Cota(grad5, new BigDecimal("40"));


        Pessoa pes1 = new Pessoa("MILITAR", "ALPHA", 2017, new BigInteger("123456789100"), "GUSTAVO EMERSON F. DIAS",
                "DIAS", "Rua 25", "CAMARAGIBE/RECIFE", grad1, emp2);
        Pessoa pes2 = new Pessoa("CIVIL", "BRAVO", 2018, new BigInteger("123456789900"), "JOÃO TESTER",
                "TESTER", "Rua 27", "OLINDA/RECIFE", grad1, emp1);
        Pessoa pes3 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "PEDRO", "Rua 25", "RECIFE/RECIFE", grad2, emp3);
        Pessoa pes4 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "JOSE", "Rua 25", "RECIFE/RECIFE", grad2, emp3);
        Pessoa pes5 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "Ulisses", "Rua 25", "RECIFE/RECIFE", grad3, emp3);
        Pessoa pes6 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "BERNARDO", "Rua 25", "RECIFE/RECIFE", grad3, emp3);
        Pessoa pes7 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "TORRES", "Rua 25", "RECIFE/RECIFE", grad4, emp3);
        Pessoa pes8 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "TENORIO", "Rua 25", "RECIFE/RECIFE", grad4, emp3);
        Pessoa pes9 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "NUNES", "Rua 25", "RECIFE/RECIFE", grad2, emp3);
        Pessoa pes10 = new Pessoa("MILITAR", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "MATHEUS", "Rua 25", "RECIFE/RECIFE", grad2, emp3);



        Trajeto tr1 = new Trajeto("Rua x/Rua Y", pes1, pas1);
        Trajeto tr2 = new Trajeto("Rua y/Rua z", pes1, pas1);
        Trajeto tr3 = new Trajeto("Rua a/Rua b", pes2, pas1);
        Trajeto tr4 = new Trajeto("Rua b/Rua c", pes2, pas1);
        Trajeto tr5 = new Trajeto("Rua c/Rua d", pes2, pas1);
        Trajeto tr6 = new Trajeto("Rua h/Rua j", pes3, pas2);
        Trajeto tr7 = new Trajeto("Rua j/Rua k", pes3, pas1);
        Trajeto tr8 = new Trajeto("Rua k/Rua l", pes3, pas1);
        Trajeto tr9 = new Trajeto("Rua l/Rua Y", pes3, pas1);





       /* pes1.getCotas().add(cota1);
        cota1.getPessoa().add(pes1);*/

        /*pes2.getCotas().addAll(Arrays.asList(cota1));
        pes3.getCotas().addAll(Arrays.asList(cota2));
        pes4.getCotas().addAll(Arrays.asList(cota2));
        pes5.getCotas().addAll(Arrays.asList(cota3));
        pes6.getCotas().addAll(Arrays.asList(cota4));
        pes7.getCotas().addAll(Arrays.asList(cota3));
        pes8.getCotas().addAll(Arrays.asList(cota1));
        pes9.getCotas().addAll(Arrays.asList(cota2));
        pes10.getCotas().addAll(Arrays.asList(cota2));*/


        pes1.getTrajetos().addAll(Arrays.asList(tr1, tr2));
        pes2.getTrajetos().addAll(Arrays.asList(tr3, tr4, tr5));
        pes3.getTrajetos().addAll(Arrays.asList(tr6, tr7, tr8, tr9));

        this.graduacaoRepository.saveAll(Arrays.asList(grad1, grad2, grad3, grad4, grad5, grad6, grad7));
        this.empresaRepository.saveAll(Arrays.asList(emp1, emp2, emp3));
        this.passagemRepository.saveAll(Arrays.asList(pas1, pas2, pas3));
        this.cotaRepository.saveAll(Arrays.asList(cota1, cota2, cota3,cota4));
        this.pessoaRepository.saveAll(Arrays.asList(pes1, pes2, pes3, pes4, pes5, pes6, pes7, pes8, pes9, pes10));
        this.trajetoRepository.saveAll(Arrays.asList(tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9));
    }

}
