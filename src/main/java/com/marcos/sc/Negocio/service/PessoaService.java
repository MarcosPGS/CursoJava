package com.marcos.sc.negocio.service;

import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.entity.PessoaEndereco;
import com.marcos.sc.repository.PessoaEnderecoRepository;
import com.marcos.sc.repository.PessoaRepository;
import com.marcos.sc.repository.TelefoneRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




@Service //essa anotação diz queminha clase é uma classe de serviços
public class PessoaService {
    @Autowired//essa anotacao injeta uma dependencia no caso a "PessoaRepository"
    PessoaRepository pessoaRepository;
    PessoaEnderecoRepository pessoaEnderecoRepository;
    TelefoneRepository telefoneRepository;


    public Pessoa salvarCompleto(Pessoa pessoa){
             
       Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        
       // ESSAS LINHAS DE CODIGO SERVE PARA SETAR O ID DE PESSOA COM O ENDEREÇO E TELEFONE
        pessoa.getPessoaEnderecos().forEach(endereco->{// SALVAR OS ENDERECO JUNTO COM PESSOA
        	endereco.setIdpessoa(pessoaSalva.getIdPessoa());
        });
        
        pessoa.getTelefones().forEach(telefone->{// SALVAR OS NUMEROS DE TELEFONE JUNTO COM PESSOA
        	telefone.setIdpessoa(pessoaSalva.getIdPessoa());
        });
        pessoaRepository.save(pessoa);  
      
    return pessoaSalva;
    }

    


    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }
    

    public Pessoa buscarCPF(String cpf){
        return pessoaRepository.buscaCpf(cpf);
    }
    

    public List<Pessoa> buscarAtivo(String ativo){
        return pessoaRepository.buscarAtivos(ativo);
    }
    
    
    public ResponseEntity<Object> consultarCpf(String cpf){
    	consutarViaMarket(cpf);
    	return consutarViaMarket(cpf);
    }
    
    public ResponseEntity<Object> consutarViaMarket(String cpf){
    	
    	String url = "https://consulta-situacao-cpf-cnpj.p.mashape.com/consultaSituacaoCPF?cpf=" + cpf;
    	String servico = url;
    	
    	ResponseEntity<Object> resultado = null;
    	
    	RestTemplate gerenciadorDeRequisicao = new RestTemplate();
    	
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