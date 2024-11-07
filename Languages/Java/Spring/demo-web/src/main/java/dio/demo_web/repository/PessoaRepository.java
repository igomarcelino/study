package dio.demo_web.repository;

import dio.demo_web.model.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaRepository  {

    public List<Pessoa> findAll(){
        Pessoa pessoa = new Pessoa("Igo","13299922210","13998882288");
        Pessoa pessoa1 = new Pessoa("Julio","89211109100","14928291122");
        Pessoa pessoa2 = new Pessoa("Aline","8332229911","11977882299");
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(pessoa);
        pessoaList.add(pessoa1);
        pessoaList.add(pessoa2);

        return pessoaList;

    }

    public Pessoa findPessoa(String nome){
        List<Pessoa> pessoaList = findAll();
        return pessoaList.stream().
                filter(n -> n.getNome().equalsIgnoreCase(nome)).findAny().get();
    }
}
