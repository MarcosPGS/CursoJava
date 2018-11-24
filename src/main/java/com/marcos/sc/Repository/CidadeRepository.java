package com.marcos.sc.repository;

import com.marcos.sc.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>,CidadeRepositoryQuery {
}
