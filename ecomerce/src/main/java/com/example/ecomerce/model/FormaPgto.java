package com.example.ecomerce.model;


import jakarta.persistence.*;

@Entity
@Table(name = "forma_pgto")
public class FormaPgto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Forma_PGTO_ID")
    private Integer id;

    @Column(name = "Descricao")
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
