package com.marcos.sc.Repository;

import com.marcos.sc.Entity.Pessoa;

import java.util.List;

public interface PessoaRepositoryQuery {


    public Pessoa buscaCpf(String cpf);// busca por CPF

    public List<Pessoa> buscarAtivos(String ativo);// busca por ativo



}
