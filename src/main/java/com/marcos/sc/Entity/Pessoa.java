package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpessoa")
    private Long idPessoa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "ativo")
    private String ativo;

    @OneToMany(mappedBy = "idpessoa",fetch = FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    private List<PessoaEndereco> pessoaEnderecos;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public List<PessoaEndereco> getPessoaEnderecos() {
        return pessoaEnderecos;
    }

    public void setPessoaEnderecos(List<PessoaEndereco> pessoaEnderecos) {
        this.pessoaEnderecos = pessoaEnderecos;
    }
}
