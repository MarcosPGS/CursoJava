package com.marcos.sc.negocio.service;

import com.marcos.sc.entity.Pessoa;
import com.marcos.sc.entity.PessoaEndereco;
import com.marcos.sc.repository.PessoaEnderecoRepository;
import com.marcos.sc.repository.PessoaRepository;
import com.marcos.sc.repository.TelefoneRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PessoaService {
    @Autowired
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
    
   
    
}