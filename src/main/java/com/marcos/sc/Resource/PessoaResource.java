package com.marcos.sc.Resource;

import com.marcos.sc.Entity.Pessoa;
import com.marcos.sc.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api")//endpoint
public class PessoaResource {

    @Autowired // injeção de dependencia
    PessoaRepository pessoaRepository;// forma errada de fazer

    @GetMapping("/pessoa")//endpoint
    public List<Pessoa> buscarPessoa(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/cpf/{cpf}")//endpoint
    public ResponseEntity<Pessoa> buscarCPF(@PathVariable String cpf){
        Pessoa pessoaResultado = pessoaRepository.buscaCpf(cpf);
        if(pessoaResultado == null){
            return ok(null);
        }
        return ok(pessoaResultado);
    }

    @GetMapping("/pessoa/ativo/{ativo}")//endpoint busca por pessoa ativa
    public List<Pessoa> buscarPessoaAtiva(@PathVariable String ativo){
        List<Pessoa> pessoaResultado = (List<Pessoa>) pessoaRepository.buscarAtivos(ativo);

        return (List<Pessoa>) pessoaResultado;
    }



    @PostMapping("/pessoa")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/pessoa") //endpoint alterar pessoa
    public Pessoa AtualizarPessoa(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }



}
