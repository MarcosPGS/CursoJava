package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_de_logradouro")
public class TipoDeLogradouro implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idtipo_de_logradouro")
    private Long idTipoDeLogradouro;
    @Column(name = "descricao")
    private String descricao;


    public Long getIdTipoDeLogradouro() {
        return idTipoDeLogradouro;
    }

    public void setIdTipoDeLogradouro(Long idTipoDeLogradouro) {
        this.idTipoDeLogradouro = idTipoDeLogradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
