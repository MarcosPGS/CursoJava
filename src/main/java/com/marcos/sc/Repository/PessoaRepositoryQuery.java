package com.marcos.sc.repository;

import com.marcos.sc.entity.Pessoa;

import java.util.List;

public interface PessoaRepositoryQuery {


    public Pessoa buscaCpf(String cpf);// busca por CPF

    public List<Pessoa> buscarAtivos(String ativo);// busca por ativo



}
