package com.marcos.sc.resource;

import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.negocio.service.PessoaService;
import com.marcos.sc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api")//endpoint
public class PessoaResource {

    @Autowired // injeção de dependencia
    PessoaService pessoaService;

    @GetMapping("/pessoa")//endpoint
    public List<Pessoa> buscarPessoa(){
        return pessoaService.listarTodos();
    }

    @GetMapping("/pessoa/cpf/{cpf}")//endpoint
    public ResponseEntity<Pessoa> buscarCPF(@PathVariable String cpf){
        Pessoa pessoaResultado = pessoaService.buscarCPF(cpf);
        if(pessoaResultado == null){
            return ok(null);
        }
        return ok(pessoaResultado);
    }

    @GetMapping("/pessoa/ativo/{ativo}")//endpoint busca por pessoa ativa
    public List<Pessoa> buscarPessoaAtiva(@PathVariable String ativo){
        List<Pessoa> pessoaResultado = (List<Pessoa>) pessoaService.buscarAtivo(ativo);


        return (List<Pessoa>) pessoaResultado;
    }



    @PostMapping("/pessoa")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){


        return pessoaService.salvarCompleto(pessoa);
    }

    //@PutMapping("/pessoa") //endpoint alterar pessoa
    //public Pessoa AtualizarPessoa(@RequestBody Pessoa pessoa){
        //return pessoaRepository.save(pessoa);
    //}



}
