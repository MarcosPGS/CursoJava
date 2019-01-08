
package com.marcos.sc.resource;

import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.exceptions.ValidarCPFException;
import com.marcos.sc.negocio.service.PessoaService;
import com.marcos.sc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin //serve para resolver o problema de domínio cruzado
@RestController //@RestController é uma versão especializada do controlador.
//Ele inclui as @Controller e @ResponseBody anotações e, como resultado, simplifica a implementação controlador:
@RequestMapping(value = "/api")//endpoint    @RequestMapping - implementar o manipulador de URLs
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
    
    @GetMapping("/pessoa/buscacpf/{cpf}")
    public ResponseEntity<Object> consultarCpf(@PathVariable String cpf){
    	return pessoaService.consultarCpf(cpf);
    }



    @PostMapping("/pessoa")
    public ResponseEntity<Object> salvarPessoa(@RequestBody Pessoa pessoa){

        try {
			return ResponseEntity.ok().body(pessoaService.salvarCompleto(pessoa));
		} catch (ValidarCPFException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }

    
    



}
