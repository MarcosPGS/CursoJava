package com.marcos.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.sc.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>, TelefoneRepositoryQuery {

}
