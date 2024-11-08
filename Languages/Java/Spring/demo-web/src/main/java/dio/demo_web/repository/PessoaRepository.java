package dio.demo_web.repository;

import dio.demo_web.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaRepository  {

    List<Pessoa> pessoaList = new ArrayList<>();
    public PessoaRepository(){
        Pessoa pessoa = new Pessoa("Igo","13299922210","13998882288");
        Pessoa pessoa1 = new Pessoa("Julio","89211109100","14928291122");
        Pessoa pessoa2 = new Pessoa("Aline","8332229911","11977882299");

        pessoaList.add(pessoa);
        pessoaList.add(pessoa1);
        pessoaList.add(pessoa2);
    }
    public List<Pessoa> findAll(){
        return pessoaList;

    }

    public Pessoa findPessoa(String nome){
        List<Pessoa> pessoaList = findAll();
        return pessoaList.stream().
                filter(n -> n.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

    public void deletePessoa(String nome){
        Pessoa pessoa = pessoaList.
                stream().
                filter(p->p.getNome().equalsIgnoreCase(nome)).
                findAny().
                get();
        pessoaList.remove(pessoa);
    }

    public void savePessoa(Pessoa pessoa){
        pessoaList.add(pessoa);
    }

    public void updatePessoa(Pessoa pessoa){
        int index = 0;
        for (Pessoa p : pessoaList){
            if(p.getNome().equalsIgnoreCase(pessoa.getNome())){
                index = pessoaList.indexOf(p);
                pessoaList.set(index,pessoa);
                break;
            }
        }

    }
}
