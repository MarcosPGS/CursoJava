package com.marcos.sc.repository;

import com.marcos.sc.entity.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long>, PessoaEnderecoQuery {

}
