package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pessoa_endereco")
public class PessoaEndereco implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idpessoa_endereco")
    private Long idPessoaEndereco;

    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;

    @Column(name = "idpessoa")
    private Long idpessoa;




   @OneToOne
   @JoinColumn(name = "idcidade")
    private Cidade cidade;

    @OneToOne
    @JoinColumn(name = "idtipo_de_logradouro")
    private TipoDeLogradouro tipoDeLogradouro;

	public Long getIdPessoaEndereco() {
		return idPessoaEndereco;
	}

	public void setIdPessoaEndereco(Long idPessoaEndereco) {
		this.idPessoaEndereco = idPessoaEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public TipoDeLogradouro getTipoDeLogradouro() {
		return tipoDeLogradouro;
	}

	public void setTipoDeLogradouro(TipoDeLogradouro tipoDeLogradouro) {
		this.tipoDeLogradouro = tipoDeLogradouro;
	}



//FIXME: significa uma pedencia a ser feita


}
