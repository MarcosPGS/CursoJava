package com.marcos.sc.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pessoa_endereco")
public class PessoaEndereco implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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


    //FIXME: para ser feita em casa;
    //FIXME: significa uma pedencia a ser feita
    //@ManyToOne(fetch = FetchType.LAZY)
    //private Tipo tipo;
    //@ManyToOne(fetch =FetchType.LAZY)
    //private Cidade cidade;
}
