package igo.com.spring_data_jpa.repository;

import igo.com.spring_data_jpa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    List<Pessoa> findByNomeContaining(String nome);
    Pessoa findByNome(String nome);
    @Query(value = "select p from Pessoa p where p.cpf like %?1")
    Pessoa findBycpf(String cpf);
}
