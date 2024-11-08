package dio.demo_web.controller;

import dio.demo_web.model.Pessoa;
import dio.demo_web.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaControler {

    @Autowired
    PessoaRepository pessoaRepository;

    @Operation(summary = "Listar todas as pessoas")
    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(){
        return pessoaRepository.findAll();
    }

    @Operation(summary = "Listar pessoa por nome")
    @GetMapping("/pessoas/{nome}")
    public Pessoa getPessoa(@PathVariable("nome") String nome){
        return pessoaRepository.findPessoa(nome);
    }

    @Operation(summary = "Deletar uma Pessoa")
    @DeleteMapping("/pessoas/{nome}")
    public void deletePessoa(@PathVariable("nome") String nome){
        pessoaRepository.deletePessoa(nome);
    }
    @Operation(summary = "Salvar uma pessoa")
    @PostMapping("/pessoas")
    public void postPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.savePessoa(pessoa);
    }

    @Operation(summary = "Atualiar Pessoa")
    @PutMapping("/pessoas")
    public void putPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.updatePessoa(pessoa);
    }

 }
