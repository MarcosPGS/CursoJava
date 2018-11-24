package com.marcos.sc.negocio.service;

import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.entity.PessoaEndereco;
import com.marcos.sc.repository.PessoaEnderecoRepository;
import com.marcos.sc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    PessoaEnderecoRepository pessoaEnderecoRepository;


    public Pessoa salvarCompleto(Pessoa pessoa){
       
//        List<PessoaEndereco> enderecos = pessoa.getPessoaEnderecos();
       
       Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        
        pessoa.getPessoaEnderecos().forEach(endereco->{
        	endereco.setIdpessoa(pessoaSalva.getIdPessoa());
        });
        
        pessoaRepository.save(pessoa);

//      for (int i= 0; i < enderecos.size();i++){
//            
//    	  PessoaEndereco endereco = enderecos.get(i);
//    	  endereco.setIdpessoa(pessoaSalva.getIdPessoa());
//          pessoaEnderecoRepository.save(endereco);
//        }
//        System.out.println(pessoa.toString());
      
      
      
      

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
}