package com.marcos.sc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.sc.negocio.service.PessoaEnderecoService;

@RestController
@RequestMapping(value = "/api")
public class PessoaEnderecoResource {
	
	
	@Autowired
	PessoaEnderecoService pessoaEnderecoService;
	
	@GetMapping("/pessoaendereco/cep/{cep}")
	public ResponseEntity<Object>buscaCep(@PathVariable String cep){
		return pessoaEnderecoService.buscaPorCep(cep);
	}
	
}
