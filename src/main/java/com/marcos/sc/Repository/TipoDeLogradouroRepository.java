package com.marcos.sc.repository;

import com.marcos.sc.entity.TipoDeLogradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeLogradouroRepository extends JpaRepository<TipoDeLogradouro, Long>, TipoDeLogradouroQuery {
}
