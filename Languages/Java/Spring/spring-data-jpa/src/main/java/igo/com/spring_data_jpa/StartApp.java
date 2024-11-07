package igo.com.spring_data_jpa;

import igo.com.spring_data_jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Override
    public void run(String... args) throws Exception {

        List<Pessoa> pessoa = pessoaRepository.findByNomeContaining("Marcelino");

        System.out.println("==========================");
        for(Pessoa p : pessoa){
            System.out.println("Nomes: " + p.getNome());
        }
        System.out.println("Pessoa por nome");
        Pessoa novaPessoa = pessoaRepository.findByNome("Igo Marcelino");
        System.out.println("Pessoas encontradas: " + novaPessoa.getNome());
        Pessoa pessoaPorCPF = pessoaRepository.findBycpf("11199922281");
        System.out.println("Pessoa localizada por cpf: " + pessoaPorCPF.getNome());
        System.out.println("==========================");

    }
}
