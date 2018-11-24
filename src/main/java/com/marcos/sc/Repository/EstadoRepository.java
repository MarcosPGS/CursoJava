package com.marcos.sc.repository;

import com.marcos.sc.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long>,EstadoRepositoryQuery {
}
