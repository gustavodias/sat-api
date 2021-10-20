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
    private final EmpresaRepository empresaRepository;
    private final PassagemRepository passagemRepository;
    private final PessoaRepository pessoaRepository;
    private final TrajetoRepository trajetoRepository;

    public DBService(CotaRepository cotaRepository, EmpresaRepository empresaRepository, PassagemRepository passagemRepository, PessoaRepository pessoaRepository, TrajetoRepository trajetoRepository) {
        this.cotaRepository = cotaRepository;
        this.empresaRepository = empresaRepository;
        this.passagemRepository = passagemRepository;
        this.pessoaRepository = pessoaRepository;
        this.trajetoRepository = trajetoRepository;
    }

    public void instaciaBaseDeDados() {


        var emp1 = new Empresa("MOBI PE");
        var emp2 = new Empresa("RODOTUR");
        var emp3 = new Empresa("TRANSCOL");

        Passagem pas1 = new Passagem("A", new BigDecimal("3.75"));
        Passagem pas2 = new Passagem("B", new BigDecimal("5.10"));
        Passagem pas3 = new Passagem("G", new BigDecimal("2.45"));

        Pessoa pes1 = new Pessoa("MILITAR", "SGT EP", "ALPHA", 2017, new BigInteger("123456789100"), "GUSTAVO EMERSON F. DIAS",
                "DIAS", "Rua 25", "CAMARAGIBE/RECIFE",emp2);
        Pessoa pes2 = new Pessoa("CIVIL", "SD EP", "BRAVO", 2018, new BigInteger("123456789900"), "JOÃO TESTER",
                "TESTER", "Rua 27", "OLINDA/RECIFE", emp1);
        Pessoa pes3 = new Pessoa("MILITAR", "CP EP", "ALPHA", 2019, new BigInteger("123456789800"), "PEDRO TESTER DIAS",
                "PEDRO", "Rua 25", "RECIFE/RECIFE",emp3);

        Cota cota1 = new Cota("SD EP", new BigDecimal("20"), pes2);
        Cota cota2 = new Cota("CB EP", new BigDecimal("30"), pes3);
        Cota cota3 = new Cota("SGT EP", new BigDecimal("40"), pes1);


        Trajeto tr1 = new Trajeto("Rua x/Rua Y", pes1, pas1);
        Trajeto tr2 = new Trajeto("Rua y/Rua z", pes1, pas1);
        Trajeto tr3 = new Trajeto("Rua a/Rua b", pes2, pas1);
        Trajeto tr4 = new Trajeto("Rua b/Rua c", pes2, pas1);
        Trajeto tr5 = new Trajeto("Rua c/Rua d", pes2, pas1);
        Trajeto tr6 = new Trajeto("Rua h/Rua j", pes3, pas2);
        Trajeto tr7 = new Trajeto("Rua j/Rua k", pes3, pas1);
        Trajeto tr8 = new Trajeto("Rua k/Rua l", pes3, pas1);
        Trajeto tr9 = new Trajeto("Rua l/Rua Y", pes3, pas1);

        pes1.getCotas().addAll(Arrays.asList(cota3));
        pes2.getCotas().addAll(Arrays.asList(cota1));
        pes3.getCotas().addAll(Arrays.asList(cota2));

        pes1.getTrajetos().addAll(Arrays.asList(tr1,tr2));
        pes2.getTrajetos().addAll(Arrays.asList(tr3,tr4,tr5));
        pes3.getTrajetos().addAll(Arrays.asList(tr6,tr7,tr8,tr9));


        this.empresaRepository.saveAll(Arrays.asList(emp1, emp2, emp3));
        this.passagemRepository.saveAll(Arrays.asList(pas1, pas2, pas3));
        this.pessoaRepository.saveAll(Arrays.asList(pes1,pes2,pes3));
        this.cotaRepository.saveAll(Arrays.asList(cota1, cota2, cota3));
        this.trajetoRepository.saveAll(Arrays.asList(tr1,tr2,tr3,tr4,tr5,tr6,tr7,tr8,tr9));
    }

}
