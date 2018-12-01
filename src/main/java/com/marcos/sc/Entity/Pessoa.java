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
    
    @OneToMany(mappedBy = "idpessoa",fetch = FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    private List<Telefone> telefones;
    
    @ManyToMany
    @JoinTable(name="pessoa_curso", joinColumns= {@JoinColumn(name="idpessoa")}, inverseJoinColumns = {@JoinColumn(name="idcurso")})
    private List<Curso> cursos;

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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
    
}
