package com.marcos.sc.Repository;

import com.marcos.sc.Entity.Pessoa;

public interface PessoaRepositoryQuery {
    public Pessoa buscaCpf(String cpf);
}
