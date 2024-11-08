package dio.demo_web.controller;

import dio.demo_web.model.Pessoa;
import dio.demo_web.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/pessoas/{nome}")
    public void deletePessoa(@PathVariable("nome") String nome){
        pessoaRepository.deletePessoa(nome);
    }
    @PostMapping("/pessoas")
    public void postPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.savePessoa(pessoa);
    }

    @PutMapping("/pessoas")
    public void putPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.updatePessoa(pessoa);
    }

 }
