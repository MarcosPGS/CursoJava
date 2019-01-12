package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity  //essa anotação @Entity serve para tornar a nossa classe uma entidade do banco de dados
@Table(name = "pessoa")  // essa anotação  @Table serve para da o nome da nossa entidade do banco de dados
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id   // essa anotação @Id serve para marcar a propriedade ID como identificador ou seja nossa chave primaria no banco de dados
    @GeneratedValue(strategy = GenerationType.AUTO)  // essa anotação @GeneratedValue serve para gerar automaticamente meu ID, ouseja um autoincremente
    @Column(name = "idpessoa")  // essa anotação @Column serve para dizer que é uma coluna da nossa entidade com seus respectivos atributos
    private Long idPessoa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "ativo")
    private String ativo;

    // essa anotação @OneToMany serve para fazer relacionamento entre entidades no meu banco de dados.
    // aqui diz que uma PESSOA pode ter 1 OU VARIOS ENDEREÇO
    @OneToMany(mappedBy = "idpessoa",fetch = FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    private List<PessoaEndereco> pessoaEnderecos;
    
    @OneToMany(mappedBy = "idpessoa",fetch = FetchType.LAZY,cascade= {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    private List<Telefone> telefones;
    
    // essa anotação @ManyToMany serve para fazer relacionamento entre entidades no meu banco de dados.
    // aqui diz que uma PESSOA pode ter varios cursos como curso pode ter varias pessoas
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

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", ativo=" + ativo
				+ ", pessoaEnderecos=" + pessoaEnderecos + ", telefones=" + telefones + ", cursos=" + cursos + "]";
	}

	
	
    
}
