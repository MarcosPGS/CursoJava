package com.marcos.sc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idcidade")
    private Long idCidade;
    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "idestado")
    private Estado estado;


    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
