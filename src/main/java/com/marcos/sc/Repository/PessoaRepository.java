package com.marcos.sc.Repository;

import com.marcos.sc.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery{



}
