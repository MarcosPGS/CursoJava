package com.marcos.sc.negocio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.marcos.sc.repository.PessoaEnderecoRepository;

@Service //essa anotação diz que minha clase é uma classe de serviços
public class PessoaEnderecoService {

	@Autowired //essa anotacao injeta uma dependencia no caso a "PessoaEnderecoRepository"
	PessoaEnderecoRepository pessoaEnderecoRepository;
	
	 public ResponseEntity<Object> buscaPorCep(String cep) {
	    	
	    	//PessoaEndereco pessoaEndereco = new PessoaEndereco();
	    	
	    	
	    	buscaPorCepViaBrasil(cep);
	    	
	    	
	    	return buscaPorCepViaBrasil(cep);
	    }
	 
	 
	 
	 
	 public ResponseEntity<Object> buscaPorCepViaBrasil(String cep){
		 String url ="https://viacep.com.br/";
		 String endPoint = "ws/" + cep + "/json/";
		 
		 String servico = url + endPoint;
		 
		 ResponseEntity<Object> resultado = null;
		 
		 
		 RestTemplate gerenciadorDeRequisicao = new RestTemplate(); //RestTemplate equivale ao http - requisição;
		 
		 //cabeçalho - obrigatorio
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		 
		HttpEntity<?> requisicao = new HttpEntity<>(httpHeaders);
		try {
			
			resultado = gerenciadorDeRequisicao.exchange(servico, HttpMethod.GET,requisicao, Object.class);
			
			
		} catch (Exception e) {
			return null;
		}
		
		
		return resultado;
	 }
}
