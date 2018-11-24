package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idestado")
    private Long idEstado;
    @Column(name = "uf")
    private String uf;
    @Column(name = "descricao")
    private String descricao;


    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
