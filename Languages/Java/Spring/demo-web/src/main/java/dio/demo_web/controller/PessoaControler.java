package dio.demo_web.controller;

import dio.demo_web.model.Pessoa;
import dio.demo_web.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaControler {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoas/{nome}")
    public Pessoa getPessoa(@PathVariable("nome") String nome){
        return pessoaRepository.findPessoa(nome);
    }
 }
